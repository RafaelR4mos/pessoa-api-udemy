package com.study.rafael.curso_rest_spring.exceptions.handler;

import org.springframework.http.HttpStatus;

public class RegraDeNegocioException extends Exception {
    private HttpStatus statusCode;

    public RegraDeNegocioException(String message) {
        super(message);
        statusCode = HttpStatus.BAD_REQUEST;
    }

    public RegraDeNegocioException(String message, HttpStatus status) {
        super(message);
        this.statusCode = status;
    }

    public HttpStatus getStatusCode() {
        return this.statusCode;
    }
}
