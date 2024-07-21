package com.example.assignment.Classes;

public class Question {
    private String id;
    private String creator;
    private String question;
    private String status;
    private String position;

    public Question(String id, String position, String question) {
        this.id = id;
        this.position = position;
        this.creator = "Unknown";
        this.question = question;
        this.status = "Pending";
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
