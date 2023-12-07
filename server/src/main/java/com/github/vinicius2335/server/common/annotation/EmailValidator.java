package com.github.vinicius2335.server.common.annotation;

import com.github.vinicius2335.server.domain.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmailValidator implements ConstraintValidator<EmailValidation, String> {
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        boolean emailIsInUse = userRepository.existsByEmail(email);
        return !emailIsInUse;
    }
}
