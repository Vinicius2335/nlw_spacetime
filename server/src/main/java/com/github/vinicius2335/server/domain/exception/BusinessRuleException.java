package com.github.vinicius2335.server.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessRuleException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 8386515803956008120L;

    public BusinessRuleException() {
        super();
    }

    public BusinessRuleException(String message) {
        super(message);
    }
}
