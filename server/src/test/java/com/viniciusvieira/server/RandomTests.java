package com.viniciusvieira.server;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes aleátorios")
class RandomTests {

    @Test
    void testeString() {
        String texto = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis enim ex, varius ut sem eget," +
                " porttitor pellentesque risus. Sed maximus blandit metus. Vestibulum ante ipsum primis in faucibus " +
                " orci luctus et ultrices posuere cubilia curae; Morbi molestie laoreet dui, in congue arcu vulputate id." +
                " Pellentesque habitant morbi tristique senectus et.";
        String excerpt = texto.substring(0, 115).concat("...");

        System.out.println(excerpt);

        assertEquals(118, excerpt.length());
    }
}
