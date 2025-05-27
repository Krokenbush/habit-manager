package com.example.habit_manager.DAO.Module;

import jakarta.persistence.*;

@Table(name = "e_audit_table")
@Entity
public class AuditTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_table_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    public AuditTable(){}

    public void setId(Long id) {
        this.id = id;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
}
