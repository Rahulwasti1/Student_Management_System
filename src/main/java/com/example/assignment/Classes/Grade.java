package com.example.assignment.Classes;

import javafx.scene.control.Button;

public class Grade {
    private String id;
    private String name;
    private String gender;
    private String percentage;
    private String email;
    private Button action;

    public Grade(String id, String name, String gender, String percentage, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.percentage = percentage;
        this.email = email;
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

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
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
