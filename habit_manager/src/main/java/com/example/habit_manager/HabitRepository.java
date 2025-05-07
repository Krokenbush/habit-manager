package com.example.habit_manager;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends CrudRepository <Habit, Long> {
    void deleteAllByUserId(Long userId);
    List<Habit> findAllByUserId(Long userId);
}
