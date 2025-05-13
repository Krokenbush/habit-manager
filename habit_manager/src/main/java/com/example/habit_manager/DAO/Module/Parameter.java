package com.example.habit_manager.DAO.Module;

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

    private Long habitId;

    public Parameter () {}

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }
    public Long getHabitId() {
        return habitId;
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