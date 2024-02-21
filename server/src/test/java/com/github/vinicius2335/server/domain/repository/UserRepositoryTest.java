package com.github.vinicius2335.server.domain.repository;

import com.github.vinicius2335.server.domain.model.User;
import com.github.vinicius2335.server.util.UserCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    private UserRepository underTest;

    private final User user = UserCreator.mockUser();

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