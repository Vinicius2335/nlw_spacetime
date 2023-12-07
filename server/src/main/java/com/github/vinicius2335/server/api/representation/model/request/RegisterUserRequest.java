package com.github.vinicius2335.server.api.representation.model.request;

import com.github.vinicius2335.server.common.annotation.EmailValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name cannot be null or blank")
    private String name;

    @EmailValidation
    @NotBlank(message = "Email cannot be null or blank")
    private String email;

    @NotBlank(message = "Password cannot be null or blank")
    private String password;

    private String avatarUrl;
}
