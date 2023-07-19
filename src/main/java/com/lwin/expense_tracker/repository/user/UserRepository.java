package com.lwin.expense_tracker.repository.user;

import com.lwin.expense_tracker.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
