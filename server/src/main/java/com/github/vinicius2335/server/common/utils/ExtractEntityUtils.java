package com.github.vinicius2335.server.common.utils;

import com.github.vinicius2335.server.domain.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class ExtractEntityUtils {
    public static User extractEntityFromContext(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null){
            return (User) authentication.getPrincipal();
        } else {
            return null;
        }
    }
}

