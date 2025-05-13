package com.example.habit_manager.DAO.Module;

import jakarta.persistence.*;

@Table(name = "e_habit")
@Entity
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_id")
    private Long id;

    @Column(name = "habit_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "regularity")
    private Regularity regularity;

    private Long userId;

    public Habit (String name, Regularity regularity) {
        this.name = name;
        this.regularity = regularity;
    }
    public Habit () {}

    public void setName (String name) {
        this.name = name;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setRegularity(Regularity regularity) {
        this.regularity = regularity;
    }

    public String getName () {
        return name;
    }
    public Regularity getRegularity () {
        return regularity;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getId() {
        return id;
    }
}
