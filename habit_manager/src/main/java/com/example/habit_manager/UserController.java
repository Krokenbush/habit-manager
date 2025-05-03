package com.example.habit_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/insertUser")
    public ResponseEntity <User> insertUser() {
        User u = userRepository.save(createUser());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    private User createUser() {
        User user = new User();
        user.setName("Andrew Stankevitch");
        user.setEmail("r@r.com");
        user.setPassword("reliablePassword228");
        user.setCreateDate(new Date());
        return user;
    }
}
