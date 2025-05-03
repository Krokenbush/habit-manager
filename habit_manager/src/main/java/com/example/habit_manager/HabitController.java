package com.example.habit_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HabitController {
    @Autowired
    private HabitRepository habitRepository;

    @GetMapping("/insertUser")
    public ResponseEntity <Habit> insertHabit() {
        Habit h = habitRepository.save(createHabit());
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    private Habit createHabit() {
        Habit h = new Habit();
        h.setName("create tasks on ROI");
        h.setRegularity(Regularity.day);
        return h;
    }
}
