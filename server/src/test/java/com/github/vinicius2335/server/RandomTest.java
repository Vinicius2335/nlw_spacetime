package com.github.vinicius2335.server;

import com.github.vinicius2335.server.common.utils.FileDeleteUtils;
import com.github.vinicius2335.server.common.utils.FileUploadUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.IOException;

class RandomTest {
    @Test
    void passwordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String devdojo = encoder.encode("devdojo");

        System.out.println(devdojo);

        Assertions.assertThat(devdojo).isNotEmpty();
    }

    @Test
    void extractFileCodeFromCoverUrl(){
        String coverUrl = "/api/download/mWZaaPGT";
        String fileCode = coverUrl.substring(14);
        System.out.println(fileCode);

        Assertions.assertThat(fileCode).isEqualTo("mWZaaPGT");
    }

    @Test
    void deleteFile() throws IOException {
        String pathDirectory = FileUploadUtils.PATH_DIRECTORY;
        String coverUrl = "/api/download/teste";

        File newFile = new File(pathDirectory + "/teste.jpg");
        boolean isFileCreated = newFile.createNewFile();

        if (isFileCreated){
            FileDeleteUtils.deleteFile(coverUrl);

            boolean expected = newFile.exists();

            Assertions.assertThat(expected).isFalse();
        }
    }
}
