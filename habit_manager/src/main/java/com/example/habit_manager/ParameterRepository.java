package com.example.habit_manager;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends CrudRepository <Parameter, Long> {
    void deleteAllByHabitId (Long habitId);
}
