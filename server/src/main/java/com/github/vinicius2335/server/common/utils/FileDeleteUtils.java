package com.github.vinicius2335.server.common.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public abstract class FileDeleteUtils {
    public static void deleteFile(String coverUrl) throws IOException {
        String fileCode = coverUrl.substring(14);

        Path uploadDirectory = Path.of(FileUploadUtils.PATH_DIRECTORY);
        Path findedFile = null;

        try (Stream<Path> files = Files.list(uploadDirectory)){
            List<Path> filesList = files.toList();

            for (Path file : filesList){
                if (file.getFileName().toString().startsWith(fileCode)) {
                    findedFile = file;
                }
            }

        } catch (IOException e) {
            throw new IOException("Error while try found files ", e);
        }

        if (findedFile != null) {
            Files.delete(findedFile);
        }
    }
}
