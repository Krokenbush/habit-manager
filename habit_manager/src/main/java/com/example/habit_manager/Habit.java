package com.example.habit_manager;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Map;

@Table(name = "e_habit")
@Entity
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_id")
    private Long id;

    @Column(name = "habit_name")
    private String name;

    @OneToMany
    private ArrayList<Parameter> parameters;

    @Enumerated(EnumType.STRING)
    @Column(name = "regularity")
    private Regularity regularity;

    @ManyToOne
    private User user_id;

    public Habit (String name, Regularity regularity) {
        this.name = name;
        this.regularity = regularity;
    }
    public Habit () {}

    public void setName (String name) {
        this.name = name;
    }
    public void setRegularity(Regularity regularity) {
        this.regularity = this.regularity;
    }

    public String getName () {
        return name;
    }
    public Regularity getRegularity () {
        return regularity;
    }
}
