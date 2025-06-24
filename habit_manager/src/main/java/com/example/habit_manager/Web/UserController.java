package com.example.habit_manager.Web;

import com.example.habit_manager.DAO.Module.Habit;
import com.example.habit_manager.DAO.Module.User;
import com.example.habit_manager.Exception.NotFoundException;
import com.example.habit_manager.Services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/insertUser")
    public ResponseEntity <User> insertUser() {
        return userService.insertUser();
    }

    @GetMapping("/getUser")
    public ResponseEntity <User> getUser(@RequestParam(name = "user_id") Long userId) throws NotFoundException  {
        return userService.getUser(userId);
    }

    @GetMapping("/getAllHabits")
    public String getAllHabits(@RequestParam(name="user_id") Long userId, Model model) throws NotFoundException {
        List<Habit> habits = userService.getAllHabits(userId);
        List<String> names = new ArrayList<>();
        for (Habit habit : habits) {
            names.add(habit.getName());
        }
        String userName = Objects.requireNonNull(userService.getUser(userId).getBody()).getName();
        model.addAttribute("userName", userName);
        model.addAttribute("names", names);
        return "showHabits";
    }

    @Transactional
    @GetMapping("/deleteUser")
    public ResponseEntity <User> deleteUser(@RequestParam(name = "user_id") Long userId) throws NotFoundException {
        return userService.deleteUser(userId);
    }
}
