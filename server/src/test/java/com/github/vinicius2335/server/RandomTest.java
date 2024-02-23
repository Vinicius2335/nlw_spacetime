package com.github.vinicius2335.server;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
}
