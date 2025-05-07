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

    public User (String name) {
        this.name = name;
    }
    public User () {}

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
