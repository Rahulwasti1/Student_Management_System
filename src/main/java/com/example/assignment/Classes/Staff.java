package com.example.assignment.Classes;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Staff {
    private final HBox action;
    private String id;
    private String name;
    private String number;
    private String gender;
    private String email;
    private String password;

    public Staff(String id, String name, String gender, String number, String email, String password) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.email = email;
        this.password = password;

        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");
        this.action = new HBox(5);
        this.action.getChildren().addAll(editButton, deleteButton);
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

    public HBox getAction() {
        return action;
    }
}
