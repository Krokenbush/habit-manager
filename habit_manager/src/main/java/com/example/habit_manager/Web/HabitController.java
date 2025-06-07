package com.example.habit_manager.Web;

import com.example.habit_manager.DAO.Module.Habit;
import com.example.habit_manager.Exception.NotFoundException;
import com.example.habit_manager.Services.HabitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HabitController {
    @Autowired
    HabitService habitService;

    @GetMapping("/insertHabit")
    public ResponseEntity <Habit> insertHabit(@RequestParam(name = "user_id") Long userId) {
        return habitService.insertHabit(userId);
    }

    @GetMapping("/getHabit")
    public ResponseEntity <Habit> getHabit(@RequestParam(name = "habit_id") Long habitId) throws NotFoundException {
        return habitService.getHabit(habitId);
    }

    @Transactional
    @GetMapping("/deleteHabit")
    public ResponseEntity <Habit> deleteHabit(@RequestParam(name = "habit_id") Long habitId) throws NotFoundException {
        return habitService.deleteHabit(habitId);
    }
}
