package com.example.assignment.Classes;

import javafx.scene.control.Button;

public class Teacher {
    private String id;
    private String name;
    private String gender;
    private String number;
    private String email;
    private String password;
    private String subject;
    private Button action;

    public Teacher(String id, String name, String gender, String number, String email, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.number = number;
        this.email = email;
        this.password = password;
        setSubject("None");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
}
