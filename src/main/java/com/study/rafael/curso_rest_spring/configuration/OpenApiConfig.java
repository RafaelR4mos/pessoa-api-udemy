package com.study.rafael.curso_rest_spring.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("RESTFUL API with Java 18 and Spring Boot 3.3")
                        .version("v1")
                        .description("CRUD de pessoa")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://github.com/RafaelR4mos")
                        )
                );
    }
}
