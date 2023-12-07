package com.github.vinicius2335.server.api.controller;

import com.github.vinicius2335.server.api.representation.model.request.AuthRequest;
import com.github.vinicius2335.server.api.representation.model.request.RegisterUserRequest;
import com.github.vinicius2335.server.api.representation.model.response.AuthResponse;
import com.github.vinicius2335.server.domain.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class AuthController {
    private final AuthService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody @Valid RegisterUserRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        return ResponseEntity.ok(authenticationService.login(request));
    }
}
