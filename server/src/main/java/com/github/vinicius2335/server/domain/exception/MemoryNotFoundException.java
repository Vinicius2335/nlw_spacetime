package com.github.vinicius2335.server.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
@SuppressWarnings("unused")
public class MemoryNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -4339778425831007138L;

    public MemoryNotFoundException() {
    }

    public MemoryNotFoundException(String message) {
        super(message);
    }

    public MemoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
