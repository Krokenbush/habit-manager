package com.example.habit_manager.Services;

import com.example.habit_manager.DAO.Module.Note;
import com.example.habit_manager.DAO.Repository.NoteRepository;
import com.example.habit_manager.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class NoteService extends AbstractService {
    @Autowired
    private NoteRepository noteRepository;

    public ResponseEntity<Note> insertNote (Long habit_id, Long audit_table_id) {
        Note n = new Note();
        n.setAuditTableId(audit_table_id);
        n.setHabitId(habit_id);
        noteRepository.save(n);
        return new ResponseEntity<>(n, HttpStatus.OK);
    }
    public ResponseEntity<Note> getNote (Long id) throws NotFoundException {
        Note n = noteRepository.findById(id).orElse(null);
        return new ResponseEntity<>(n, checkByNull(n));
    }
    public ResponseEntity<Note> deleteNote (Long id) throws NotFoundException {
        Note n = noteRepository.findById(id).orElse(null);
        if (n == null) {
            throw new NotFoundException("Note не найден.");
        } else {
            noteRepository.delete(n);
            return new ResponseEntity<>(n, HttpStatus.OK);
        }
    }
}
