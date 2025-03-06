package com.app.jdbc.smartrecruit.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role",
        discriminatorType = DiscriminatorType.STRING)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;
    private String email;
    private String password;
    private LocalDate birthdate;
    private LocalDate createdAt;
    private LocalTime updatedAt;

    public User() {}
//    public User(long userId, String name, String userName, String email, String password, LocalDate createdAt, LocalTime updatedAt) {
//        this.userId = userId;
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }
//
//    public User( String name, String userName, String email, String password) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.createdAt = LocalDate.now();
//        this.updatedAt = LocalTime.now();
//    }

    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public LocalTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
