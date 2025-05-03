package com.example.habit_manager;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Table(name = "e_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "passwd")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "create_date")
    private Date createDate;

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
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public Long getId() {
        return id;
    }
}
