package com.example.habit_manager.DAO.Repository;

import com.example.habit_manager.DAO.Module.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    void deleteAllByAuditTableId(Long id);
}
