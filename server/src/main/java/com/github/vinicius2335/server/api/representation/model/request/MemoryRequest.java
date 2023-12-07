package com.github.vinicius2335.server.api.representation.model.request;

import com.github.vinicius2335.server.domain.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

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
