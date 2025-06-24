package com.example.habit_manager.Services;

import com.example.habit_manager.DAO.Module.Habit;
import com.example.habit_manager.DAO.Module.User;
import com.example.habit_manager.DAO.Repository.HabitRepository;
import com.example.habit_manager.DAO.Repository.ParameterRepository;
import com.example.habit_manager.DAO.Repository.UserRepository;
import com.example.habit_manager.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;

@Service
public class UserService extends AbstractService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HabitRepository habitRepository;
    @Autowired
    private ParameterRepository parameterRepository;

    public ResponseEntity <User> insertUser () {
        User u = userRepository.save(createUser());
        return ResponseEntity.ok(u);
    }

    public ResponseEntity <User> getUser (Long userId) throws NotFoundException {
        User u = userRepository.findById(userId).orElse(null);
        return new ResponseEntity<>(u, checkByNull(u));
    }

    public ResponseEntity<User> deleteUser (Long userId) throws NotFoundException {
        User u = userRepository.findById(userId).orElse(null);

        if (u == null) {
            throw new NotFoundException("User не найден.");
        }

        List<Habit> habits = habitRepository.findAllByUserId(userId);
        for (Habit habit : habits) {
            parameterRepository.deleteAllByHabitId(habit.getId());
        }
        habitRepository.deleteAllByUserId(userId);
        userRepository.delete(u);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    public List <Habit> getAllHabits (Long userId) throws NotFoundException {
        User u = userRepository.findById(userId).orElse(null);
        if (u == null) {
            throw new NotFoundException("User не найден");
        }
        return habitRepository.findAllByUserId(userId);
    }

    private User createUser() {
        User user = new User();
        user.setName("Georgy");
        user.setEmail("r@r.com");
        user.setPassword("reliablePassword228");
        user.setCreateDate(new Date());
        return user;
    }
}
