package com.expense.expense_tracker_devops.controller;

import com.expense.expense_tracker_devops.model.User;
import com.expense.expense_tracker_devops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder =
            new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        Optional<User> existingUser =
                userRepository.findByEmail(user.getEmail());

        if(existingUser.isPresent()) {

            return ResponseEntity.badRequest()
                    .body("Email already exists");
        }

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginUser) {

        Optional<User> user =
                userRepository.findByEmail(loginUser.getEmail());

        if(user.isEmpty()) {

            return ResponseEntity.badRequest()
                    .body("User not found");
        }

        boolean passwordMatch =
                passwordEncoder.matches(
                        loginUser.getPassword(),
                        user.get().getPassword()
                );

        if(!passwordMatch) {

            return ResponseEntity.badRequest()
                    .body("Invalid password");
        }

        Map<String, String> response = new HashMap<>();

        response.put("message", "Login successful");

        response.put("username", user.get().getUsername());

        return ResponseEntity.ok(response);

    }

}
