package com.study.rafael.curso_rest_spring.controllers;

import com.study.rafael.curso_rest_spring.dto.v1.User.AuthenticationDTO;
import com.study.rafael.curso_rest_spring.dto.v1.User.LoginResponseDTO;
import com.study.rafael.curso_rest_spring.dto.v1.User.RegisterDTO;
import com.study.rafael.curso_rest_spring.entities.UserEntity;
import com.study.rafael.curso_rest_spring.repositories.UserRepository;
import com.study.rafael.curso_rest_spring.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@Tag(name = "Auth", description = "Endpoints for authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    @Operation(summary = "log a user", description = "Logs a user and returns JWT Token", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content =  {
                    @Content(
                            schema = @Schema(implementation = LoginResponseDTO.class)
                    )
            })
    })
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        System.out.println(data.getLogin() + data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("register")
    @Operation(summary = "register a user", description = "register a user in database", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content)
    })
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        if(this.userRepository.findByLogin(data.getLogin()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        UserEntity newUser = new UserEntity(data.getLogin(), encryptedPassword);

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
