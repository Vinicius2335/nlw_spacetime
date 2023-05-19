package com.viniciusvieira.server.api.controller;

import com.viniciusvieira.server.api.representation.model.request.MemoryRequest;
import com.viniciusvieira.server.api.representation.model.response.MemoryResponse;
import com.viniciusvieira.server.domain.model.Github;
import com.viniciusvieira.server.domain.model.Memory;
import com.viniciusvieira.server.domain.service.MemoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    // TODO fazer exceptionHandler
    private final MemoryService memoryService;

    @GetMapping("/memories")
    public ResponseEntity<List<Memory>> findAllMemories() {
        List<Memory> memories = memoryService.findAllMemories();
        return ResponseEntity.ok(summarizesContentForAllMemories(memories));
    }

    @GetMapping("/memories/{idMemory}")
    public ResponseEntity<Memory> findMemoryById(@PathVariable UUID idMemory) {
        return ResponseEntity.ok(memoryService.findMemoryById(idMemory));
    }

    @PostMapping("/memories")
    public ResponseEntity<MemoryResponse> createNewMemory(@RequestBody @Valid MemoryRequest memoryRequest) {
        Github userGithubInfo = getUserGithubInfo();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memoryService.createNewMemory(memoryRequest, userGithubInfo));
    }

    @PutMapping("/memories/{idMemory}")
    public ResponseEntity<MemoryResponse> updateMemoryById(@PathVariable UUID idMemory, @RequestBody @Valid MemoryRequest memoryRequest) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(memoryService.updateMemoryById(idMemory, memoryRequest));
    }

    @DeleteMapping("/memories/{idMemory}")
    public ResponseEntity<String> deleteMemoryById(@PathVariable UUID idMemory) {
        memoryService.deleteMemoryById(idMemory);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Successfully deleted memory...");
    }

    // BUG excluir depois
    @GetMapping("/teste")
    public Github teste(){
        return getUserGithubInfo();
    }

    //BUG excluir depois
    @GetMapping("/user")
    public Map<String, Object> getUser(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
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

    private List<Memory> summarizesContentForAllMemories(List<Memory> memories){
        for (Memory memory : memories){
            memory.setContent(memory.getContent().substring(0, 115).concat("..."));
        }
        return memories;
    }
}
