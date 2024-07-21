package com.example.assignment.Classes;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Activity {
    private final HBox action;
    private String id;
    private String type;
    private String date;

    public Activity(String id, String type, String date) {
        this.id = id;
        this.type = type;
        this.date = date;

        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        this.action = new HBox(5);
        this.action.getChildren().addAll(editButton, deleteButton);
    }

    public HBox getAction() {
        return action;
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
