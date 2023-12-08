package com.github.vinicius2335.server.domain.service;

import com.github.vinicius2335.server.api.mapper.UserMapper;
import com.github.vinicius2335.server.api.representation.model.request.AuthRequest;
import com.github.vinicius2335.server.api.representation.model.request.RegisterUserRequest;
import com.github.vinicius2335.server.api.representation.model.response.AuthResponse;
import com.github.vinicius2335.server.api.representation.model.response.UserResponse;
import com.github.vinicius2335.server.common.security.service.JwtService;
import com.github.vinicius2335.server.domain.model.User;
import com.github.vinicius2335.server.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Transactional
    public Map<String, String> register(RegisterUserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encodePassword(request.getPassword()))
                .avatarUrl(request.getAvatarUrl())
                .build();

        userRepository.save(user);
        Map<String, Object> claims = getClaims(user);

        String jwtToken = jwtService.generateToken(claims, user);

        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);

        return response;
    }

    private static Map<String, Object> getClaims(User user) {
        Map<String, Object> claims = new HashMap<>();

        String roles = user.getRolesToString();
        claims.put("roles", roles);
        claims.put("name", user.getName());
        claims.put("avatarUrl", user.getAvatarUrl());
        return claims;
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        Map<String, Object> claims = getClaims(user);

        String jwtToken = jwtService.generateToken(claims, user);

        UserResponse userResponse = userMapper.toUserResponse(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .user(userResponse)
                .build();
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

}
