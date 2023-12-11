package com.github.vinicius2335.server.api.representation.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FileUploadResponse {
    @NonNull
    private String fileName;

    @NonNull
    private Long size;

    @NonNull
    private String type;

    @NonNull
    private String downloadUri;
}
