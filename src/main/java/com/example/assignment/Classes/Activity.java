package com.example.assignment.Classes;

import javafx.scene.control.Button;

public class Activity {
    private String id;
    private String type;
    private String date;
    private Button action;

    public Activity(String id, String type, String date) {
        this.id = id;
        this.type = type;
        this.date = date;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
