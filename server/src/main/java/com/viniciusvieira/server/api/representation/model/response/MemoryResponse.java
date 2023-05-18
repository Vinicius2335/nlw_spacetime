package com.viniciusvieira.server.api.representation.model.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemoryResponse {
    private String coverUrl;
    private String content;
    private boolean isPublic;
    private LocalDateTime createdAt;
}
