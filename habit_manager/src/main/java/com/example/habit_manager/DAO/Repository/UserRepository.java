package com.example.habit_manager.DAO.Repository;

import com.example.habit_manager.DAO.Module.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
}
