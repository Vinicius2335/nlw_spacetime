package com.github.vinicius2335.server.api.representation.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemoryRequest {
    @NotBlank(message = "CoverURL cannot be null or empty")
    private String coverUrl;

    @NotBlank(message = "Content cannot be null or empty")
    private String content;

    private boolean isPublic;
}
