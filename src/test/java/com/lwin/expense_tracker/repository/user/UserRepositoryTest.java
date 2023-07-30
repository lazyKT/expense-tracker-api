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

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void UserRepository_AddUser_ReturnNewUser () {
        User user = User.builder()
                .email("test@expensetracker.com")
                .roles("ROLE_USER")
                .password("Password")
                .build();
        User newUser = userRepository.save(user);

        Assertions.assertThat(newUser).isNotNull();
        Assertions.assertThat(newUser.getEmail()).isEqualTo("test@expensetracker.com");
    }

    @Test
    public void UserRepository_GetAllUsers_ReturnUserList () {
        User user1 = User.builder()
                .email("test1@expensetracker.com")
                .roles("ROLE_USER")
                .password("Password")
                .build();
        User user2 = User.builder()
                .email("test2@expensetracker.com")
                .roles("ROLE_USER")
                .password("Password")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);

        List<User> users = userRepository.findAll();

        Assertions.assertThat(users).isNotNull();
        Assertions.assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void UserRepository_FindById_ReturnUser () {
        User user = User.builder()
                .email("test@expensetracker.com")
                .roles("ROLE_USER")
                .password("Password")
                .build();
        userRepository.save(user);

        Optional<User> result = userRepository.findById(user.getId());

        Assertions.assertThat(result.isPresent()).isTrue();
        Assertions.assertThat(result.get()).isNotNull();
        Assertions.assertThat(result.get().getId()).isEqualTo(user.getId());
    }

    @Test
    public void UserRepository_FindByEmail_ReturnUser () {
        User user = User.builder()
                .email("test@expensetracker.com")
                .roles("ROLE_USER")
                .password("Password")
                .build();
        userRepository.save(user);

        Optional<User> result = userRepository.findByEmail(user.getEmail());
        Assertions.assertThat(result.isPresent()).isTrue();
        Assertions.assertThat(result.get()).isNotNull();
        Assertions.assertThat(result.get().getEmail()).isEqualTo(user.getEmail());
    }
}
