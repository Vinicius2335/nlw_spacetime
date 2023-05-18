package com.viniciusvieira.server.domain.exception;

import java.io.Serial;

public class MemoryNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 8243129897019335837L;

    public MemoryNotFoundException(String message) {
        super(message);
    }
}
