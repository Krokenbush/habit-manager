package com.example.habit_manager.Services;

import com.example.habit_manager.DAO.Module.AuditTable;
import com.example.habit_manager.DAO.Repository.AuditTableRepository;
import com.example.habit_manager.DAO.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuditTableService extends AbstractService {
    @Autowired
    private AuditTableRepository auditTableRepository;
    @Autowired
    private NoteRepository noteRepository;

    public ResponseEntity<AuditTable> insertAuditTable (Long user_id) {
        AuditTable at = new AuditTable();
        at.setUserId(user_id);
        auditTableRepository.save(at);
        return new ResponseEntity<>(at, HttpStatus.OK);
    }
    public ResponseEntity<AuditTable> getAuditTable (Long id) {
        AuditTable at = auditTableRepository.findById(id).orElse(null);
        return new ResponseEntity<>(at, checkByNull(at));
    }
    public ResponseEntity<AuditTable> deleteAuditTable (Long id) {
        AuditTable at = auditTableRepository.findById(id).orElse(null);
        if (at == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            noteRepository.deleteAllByAuditTableId(id);
            auditTableRepository.delete(at);
            return new ResponseEntity<>(at, HttpStatus.OK);
        }
    }
}
