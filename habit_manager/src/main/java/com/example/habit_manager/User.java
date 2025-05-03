package com.example.habit_manager;

import jakarta.persistence.*;
import java.util.ArrayList;

@Table(name = "e_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @OneToMany
    ArrayList<Habit> habits;

    public User (String name, ArrayList<Habit> habits) {
        this.name = name;
        this.habits = habits;
    }
    public User () {}

    public void setHabits(ArrayList<Habit> habits) {
        this.habits = habits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Habit> getHabits() {
        return habits;
    }

    public String getName() {
        return name;
    }
}
