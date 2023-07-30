package com.lwin.expense_tracker.repository.user;

import com.lwin.expense_tracker.entity.user.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_AddUser_ReturnString () {
        User user = User.builder()
                .email("test@expensetracker.com")
                .roles("ROLE_USER")
                .password("Password")
                .build();
        User newUser = userRepository.save(user);

        Assertions.assertThat(newUser).isNotNull();
    }
}
