package com.example.assignment.Classes;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Student {
    private final HBox action;
    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String gender;
    private String phoneNumber;
    private String email;
    private String faculty;
    private String password;

    public Student(String id, String firstName, String lastName, String gender, String phoneNumber, String email, String faculty, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.faculty = faculty;
        this.password = password;

        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");


        this.action = new HBox(5);
        this.action.getChildren().addAll(editButton, deleteButton);
    }

    public HBox getAction() {
        return action;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", faculty='" + faculty + '\'' +
                ", password='" + password + '\'' +
                ", action=" + action +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
