package com.example.assignment.Classes;

import javafx.scene.control.Button;

public class Staff {
    private String id;
    private String name;
    private String number;
    private String gender;
    private String email;
    private String password;
    private Button action;

    public Staff(String id, String name, String gender, String number, String email, String password) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }
}
