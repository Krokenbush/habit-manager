package com.example.habit_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HabitController {
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private ParameterRepository parameterRepository;

    @GetMapping("/insertHabit")
    public ResponseEntity <Habit> insertHabit(@RequestParam(name = "user_id") Long userId) {
        Habit h = habitRepository.save(createHabit(userId));
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @GetMapping("/getHabit")
    public ResponseEntity <Habit> getHabit(@RequestParam(name = "habit_id") Long habitId) {
        Habit h = habitRepository.findById(habitId).orElseThrow();
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @GetMapping("/deleteHabit")
    public ResponseEntity <Habit> deleteHabit(@RequestParam(name = "habit_id") Long habitId) {
        Habit h = habitRepository.findById(habitId).orElseThrow();
        ResponseEntity <Habit> re = new ResponseEntity<>(h, HttpStatus.OK);
        parameterRepository.deleteAllByHabitId(habitId);
        habitRepository.delete(h);
        return re;
    }

    private Habit createHabit(Long userId) {
        Habit h = new Habit();
        h.setName("create tasks on ROI");
        h.setUserId(userId);
        h.setRegularity(Regularity.day);
        return h;
    }
}
