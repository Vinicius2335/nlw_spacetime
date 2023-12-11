package com.github.vinicius2335.server.common.utils;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public abstract class FileDownloadUtils {

    public static Resource getFileAsResource(String fileCode) throws IOException {
        Path uploadDirectory = Path.of(FileUploadUtils.PATH_DIRECTORY);
        Path foundFile = null;

        try (Stream<Path> files = Files.list(uploadDirectory)){
            List<Path> filesList = files.toList();

            for (Path file : filesList){
                if (file.getFileName().toString().startsWith(fileCode)) {
                    foundFile = file;
                }
            }

        } catch (IOException e) {
            throw new IOException("Error while try found files ", e);
        }

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}
