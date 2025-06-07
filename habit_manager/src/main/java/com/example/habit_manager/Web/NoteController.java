package com.example.habit_manager.Web;

import com.example.habit_manager.DAO.Module.Note;
import com.example.habit_manager.Exception.NotFoundException;
import com.example.habit_manager.Services.NoteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping("/insertNote")
    public ResponseEntity<Note> insertNote
            (
                @RequestParam(name = "audit_table_id") Long audit_table_id,
                @RequestParam(name = "habit_id") Long habit_id
            )
    {
        return noteService.insertNote(habit_id, audit_table_id);
    }

    @GetMapping("/getNote")
    public ResponseEntity<Note> getNote (@RequestParam(name = "note_id") Long id) throws NotFoundException  {
        return noteService.getNote(id);
    }

    @Transactional
    @GetMapping("/deleteNote")
    public ResponseEntity<Note> deleteNote (@RequestParam(name = "note_id") Long id) throws NotFoundException {
        return noteService.deleteNote(id);
    }
}
