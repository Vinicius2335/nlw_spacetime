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
}
