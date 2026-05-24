package com.expense.expense_tracker_devops.repository;

import com.expense.expense_tracker_devops.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}