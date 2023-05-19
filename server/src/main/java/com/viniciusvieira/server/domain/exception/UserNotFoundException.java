package com.viniciusvieira.server.domain.exception;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 4350300260313761419L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
