package com.github.vinicius2335.server.api.representation.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthResponse {
    @NonNull
    private String token;
    @NonNull
    private UserResponse user;
}
