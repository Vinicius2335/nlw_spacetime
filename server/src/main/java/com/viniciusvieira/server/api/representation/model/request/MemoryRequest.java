package com.viniciusvieira.server.api.representation.model.request;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "cover url não pode nulo ou estar em branco")
    private String coverUrl;

    @NotBlank(message = "content não pode ser nulo ou estar em branco")
    private String content;

    private boolean isPublic;
}
