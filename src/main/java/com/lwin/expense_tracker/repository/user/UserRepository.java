package com.lwin.expense_tracker.repository.user;

import com.lwin.expense_tracker.entity.user.EmailLogin;
import com.lwin.expense_tracker.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserId(int userId);

    Optional<EmailLogin> findByUserEmail(String userEmail);
}
