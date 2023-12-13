package com.github.vinicius2335.server.util;

import com.github.vinicius2335.server.domain.model.User;

import java.util.ArrayList;
import java.util.UUID;

public abstract class UserCreator {
    public static User mockUser(){
        return User.builder()
                .id(UUID.randomUUID())
                .name("Vinicius Vieira")
                .email("vinicius@gmail.com")
                .avatarUrl("avatar.com.br")
                .memories(new ArrayList<>())
                .build();
    }
}
