package com.example.habit_manager.Web;

import com.example.habit_manager.DAO.Module.User;
import com.example.habit_manager.Services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/insertUser")
    public ResponseEntity <User> insertUser() {
        return userService.insertUser();
    }

    @GetMapping("/getUser")
    public ResponseEntity <User> getUser(@RequestParam(name = "user_id") Long userId) {
        return userService.getUser(userId);
    }

    @Transactional
    @GetMapping("/deleteUser")
    public ResponseEntity <User> deleteUser(@RequestParam(name = "user_id") Long userId) {
        return userService.deleteUser(userId);
    }
}
