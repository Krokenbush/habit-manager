package com.example.habit_manager;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private ParameterRepository parameterRepository;

    @GetMapping("/insertUser")
    public ResponseEntity <User> insertUser() {
        User u = userRepository.save(createUser());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping("/getUser")
    public ResponseEntity <User> getUser(@RequestParam(name = "user_id") Long userId) {
        User u = userRepository.findById(userId).orElse(new User());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/deleteUser")
    public ResponseEntity <User> deleteUser(@RequestParam(name = "user_id") Long userId) {
        User u = userRepository.findById(userId).orElseThrow();
        ResponseEntity <User> res = new ResponseEntity<>(u, HttpStatus.OK);

        List <Habit> habits = habitRepository.findAllByUserId(userId);
        for (Habit habit : habits) {
            parameterRepository.deleteAllByHabitId(habit.getId());
        }
        habitRepository.deleteAllByUserId(userId);
        userRepository.delete(u);
        return res;
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
