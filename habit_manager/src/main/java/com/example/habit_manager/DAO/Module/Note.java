package com.example.habit_manager.DAO.Module;

import java.util.Date;
import jakarta.persistence.*;

@Table(name = "e_note")
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long id;

    @Column(name = "audit_table_id")
    private Long auditTableId;

    @Column(name = "habit_id")
    private Long habitId;

    @Column(name = "create_date")
    private Date date;

    public Note () {}

    public void setId(Long id) {
         this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setAuditTableId(Long auditTableId) {
        this.auditTableId = auditTableId;
    }
    public Long getAuditTableId() {
        return auditTableId;
    }
    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }
    public Long getHabitId() {
        return habitId;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
}
