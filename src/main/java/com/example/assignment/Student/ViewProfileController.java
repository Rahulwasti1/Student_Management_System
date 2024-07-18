package com.example.assignment.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.assignment.Uses.changeScene;

public class ViewProfileController {

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Student/Dashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentViewProfile(ActionEvent event) throws IOException {
        changeScene(event, "Student/ManageStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentViewCourse(ActionEvent event) throws IOException {
        changeScene(event, "Student/ManageTeacher.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentQuestionFrom(ActionEvent event) throws IOException {
        changeScene(event, "Student/ManageStaff.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentReportFrom(ActionEvent event) throws IOException {
        changeScene(event, "Student/ManageActivities.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentMCQ(ActionEvent event) throws IOException {
        changeScene(event, "Student/ManageActivities.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
