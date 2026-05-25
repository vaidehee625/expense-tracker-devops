package com.expense.expense_tracker_devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ExpenseTrackerDevopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackerDevopsApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "index";
    }
}
