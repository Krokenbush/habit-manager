package com.example.habit_manager.Services;

import com.example.habit_manager.DAO.Module.Habit;
import com.example.habit_manager.DAO.Repository.HabitRepository;
import com.example.habit_manager.DAO.Repository.ParameterRepository;
import com.example.habit_manager.DAO.Module.Regularity;
import com.example.habit_manager.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HabitService extends AbstractService {
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private ParameterRepository parameterRepository;

    public ResponseEntity <Habit> insertHabit (Long userId) {
        Habit h = habitRepository.save(createHabit(userId));
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    public ResponseEntity <Habit> getHabit (Long habitId) throws NotFoundException {
        Habit h = habitRepository.findById(habitId).orElse(null);
        return new ResponseEntity<>(h, checkByNull(h));
    }

    public ResponseEntity <Habit> deleteHabit (Long habitId) throws NotFoundException {
        Habit h = habitRepository.findById(habitId).orElse(null);
        if (h == null) {
            throw new NotFoundException("Habit не найден.");
        } else {
            parameterRepository.deleteAllByHabitId(habitId);
            habitRepository.delete(h);
            return new ResponseEntity<>(h, HttpStatus.OK);
        }
    }

    private Habit createHabit(Long userId) {
        Habit h = new Habit();
        h.setName("create tasks on ROI");
        h.setUserId(userId);
        h.setRegularity(Regularity.day);
        return h;
    }
}
