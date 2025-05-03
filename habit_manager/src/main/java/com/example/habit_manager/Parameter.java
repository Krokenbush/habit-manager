package com.example.habit_manager;

import jakarta.persistence.*;

@Table(name = "e_parameter")
@Entity
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "param_id")
    private Long id;

    @Column(name = "param_name")
    private String name;

    @Column(name = "param_value")
    private int value;

    @Column(name = "param_description")
    private String description;

    @ManyToOne
    private Habit HabitId;

    public Parameter () {}

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setHabitId(Habit habitId) {
        HabitId = habitId;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }
    public Habit getHabitId() {
        return HabitId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getValue() {
        return value;
    }
}