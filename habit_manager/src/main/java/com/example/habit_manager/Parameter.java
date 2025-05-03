package com.example.habit_manager;

import jakarta.persistence.*;

@Table(name = "e_parameter")
@Entity
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "param_name")
    private String name;

    @Column(name = "param_value")
    private String value;

    @Column(name = "param_description")
    private String description;

    @ManyToOne
    private Habit HabitId;
}