package com.viniciusvieira.server.api.controller;

import com.viniciusvieira.server.domain.model.Github;
import com.viniciusvieira.server.domain.model.Memory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NlwSpacetimeController {
    // TODO implementar o controller

    @GetMapping("/user")
    public String getUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        Map<String, Object> userAttributes = oAuth2AuthenticationToken.getPrincipal().getAttributes();
        return "Login: " + userAttributes.get("login")
                + "\nGitHub ID: " + userAttributes.get("id")
                + "\nAvatar URL: " + userAttributes.get("avatar_url");
    }

    @GetMapping("/memories")
    public ResponseEntity<List<Memory>> findAllMemories() {
        return null;
    }

    @GetMapping("/memories/{idMemory}")
    public ResponseEntity<Memory> findMemoryById(@PathVariable UUID idMemory) {
        return null;
    }

    @PostMapping("/memories")
    public ResponseEntity<Memory> createNewMemory(@RequestBody Memory memory) {
        return null;
    }

    @PutMapping("/memories/{idMemory}")
    public ResponseEntity<Memory> updateMemoryById(@PathVariable UUID idMemory, @RequestBody Memory memory) {
        return null;
    }

    @DeleteMapping("/memories/{idMemory}")
    public ResponseEntity<String> deleteMemoryById(@PathVariable UUID idMemory) {
        return ResponseEntity.ok("Memory deletado com sucesso");
    }

    @GetMapping("/teste")
    public Github teste(){
        return getUserGithubInfo();
    }

    private Github getUserGithubInfo() {
        DefaultOAuth2User userGithubInfo = (DefaultOAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String, Object> userAttributes = userGithubInfo.getAttributes();
        return Github.builder()
                .login(String.valueOf(userAttributes.get("login")))
                .id(Integer.parseInt(String.valueOf(userAttributes.get("id"))))
                .avatarUrl(String.valueOf(userAttributes.get("avatar_url")))
                .build();
    }
}
