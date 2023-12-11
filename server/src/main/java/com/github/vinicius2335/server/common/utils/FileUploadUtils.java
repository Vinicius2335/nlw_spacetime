package com.github.vinicius2335.server.common.utils;

import com.github.vinicius2335.server.api.representation.model.response.FileUploadResponse;
import com.github.vinicius2335.server.domain.exception.BusinessRuleException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Log4j2
public abstract class FileUploadUtils {
    public static final String PATH_DIRECTORY = "src/main/resources/static/files";

    public static FileUploadResponse uploadFile(MultipartFile file) throws IOException {
        try {
            if (!file.getContentType().startsWith("image") && !file.getContentType().startsWith("video")){
                // TODO - Exception Handler
                throw new BusinessRuleException("Incorrect file type, image or video only");
            }

            String fileCode = upload(file);
            log.info("Successfully, File is uploaded!");

            return generateResponse(file, fileCode);
        } catch (IOException e) {
            throw new IOException("Error while try upload file. . .");
        }
    }

    private static FileUploadResponse generateResponse(MultipartFile file, String fileCode) {
        return FileUploadResponse.builder()
                .fileName(Objects.requireNonNull(file.getOriginalFilename()))
                .size(file.getSize())
                .type(Objects.requireNonNull(file.getContentType()))
                .downloadUri("/api/download/" + fileCode)
                .build();

    }

    private static String upload(MultipartFile file) throws IOException {
        String fileCode = generateRandomCode();
        String fileName = fileCode + "-" + file.getOriginalFilename();

        Files.copy(
                file.getInputStream(),
                Paths.get(FileUploadUtils.PATH_DIRECTORY + File.separator + fileName),
                StandardCopyOption.REPLACE_EXISTING
        );

        return fileCode;
    }

    private static String generateRandomCode() {
        return RandomStringUtils.randomAlphabetic(8);
    }


}
