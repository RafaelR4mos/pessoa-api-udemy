package com.study.rafael.curso_rest_spring.exceptions;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ErrorValidation {

    private Date timestamp;
    private Long status;
    private Map<String, String> errors;

    public ErrorValidation(Date timestamp, Long status, Map<String, String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.errors = errors;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Long getStatus() {
        return this.status;
    }

    public Map<String, String> getErrors() {
        return this.errors;
    }
}
