package com.github.vinicius2335.server.domain.repository;

import com.github.vinicius2335.server.domain.model.User;
import com.github.vinicius2335.server.util.UserCreator;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
class UserRepositoryTest {
    @Autowired
    private UserRepository underTest;

    private User user = UserCreator.mockUser();

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    @DisplayName("save() save new user")
    void givenUser_whenSave_thenUserShouldBeInserted(){
        // given
        // when
        User userSaved = underTest.save(user);
        // then
        assertThat(userSaved)
                .isNotNull()
                .usingRecursiveComparison()
                .ignoringFields("id", "createdAt")
                .isEqualTo(user);
    }
}