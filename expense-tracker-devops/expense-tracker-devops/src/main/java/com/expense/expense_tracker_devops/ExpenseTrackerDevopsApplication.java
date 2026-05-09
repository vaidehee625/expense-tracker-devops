package com.expense.expense_tracker_devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExpenseTrackerDevopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerDevopsApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Expense Tracker DevOps App Running Successfully!";
	}
}