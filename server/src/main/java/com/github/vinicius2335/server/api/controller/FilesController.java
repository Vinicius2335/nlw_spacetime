package com.github.vinicius2335.server.api.controller;

import com.github.vinicius2335.server.api.representation.model.response.FileUploadResponse;
import com.github.vinicius2335.server.common.utils.FileDownloadUtils;
import com.github.vinicius2335.server.common.utils.FileUploadUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class FilesController {

    @PostMapping("/upload")
    public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileUploadResponse response = FileUploadUtils.uploadFile(file);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/download/{fileCode}")
    public ResponseEntity<?> downloadFile(@PathVariable String fileCode) {
        Resource resource;

        try {
            resource = FileDownloadUtils.getFileAsResource(fileCode);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        if (resource == null) {
            return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
        }

        String contentType;

        if (Objects.requireNonNull(resource.getFilename()).endsWith(".png") ||
                Objects.requireNonNull(resource.getFilename().endsWith(".jpeg"))){
            contentType = "image/jpeg";
        } else {
            contentType = "video/mp4";
        }

        String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                .body(resource);
    }
}
