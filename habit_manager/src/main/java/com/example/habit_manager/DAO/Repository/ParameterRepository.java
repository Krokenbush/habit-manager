package com.example.habit_manager.DAO.Repository;

import com.example.habit_manager.DAO.Module.Parameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends CrudRepository <Parameter, Long> {
    void deleteAllByHabitId (Long habitId);
}
