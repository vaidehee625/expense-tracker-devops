package com.expense.expense_tracker_devops.repository;

import com.expense.expense_tracker_devops.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

}