package com.example.habit_manager.Web;

import com.example.habit_manager.DAO.Module.AuditTable;
import com.example.habit_manager.Exception.NotFoundException;
import com.example.habit_manager.Services.AuditTableService;
import com.example.habit_manager.Services.HabitService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuditTableController {
    @Autowired
    AuditTableService auditTableService;

    @GetMapping("/insertAuditTable")
    public ResponseEntity<AuditTable> insertAuditTable(@RequestParam(name = "user_id") Long id) {
        return auditTableService.insertAuditTable(id);
    }

    @GetMapping("/getAuditTable")
    public ResponseEntity<AuditTable> getAuditTable(@RequestParam(name = "audit_table_id") Long id) throws NotFoundException {
        return auditTableService.getAuditTable(id);
    }

    @Transactional
    @GetMapping("/deleteAuditTable")
    public ResponseEntity<AuditTable> deleteAuditTable(@RequestParam(name = "audit_table_id") Long id) throws NotFoundException {
        return auditTableService.deleteAuditTable(id);
    }
}
