package com.example.assignment.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.assignment.Static.Uses.changeScene;


public class EnrolledCourseController {

    @FXML
    public void clickStudentDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Student/Dashboard.fxml", "Student - Dashboard");
    }

    @FXML
    public void clickStudentViewProfile(ActionEvent event) throws IOException {
        changeScene(event, "Student/ViewProfile.fxml", "Student - ");

    }

    @FXML
    public void clickStudentViewCourse(ActionEvent event) throws IOException {
        changeScene(event, "Student/ViewCourse.fxml", "Student - Courses");
    }

    @FXML
    public void clickStudentQuestionFrom(ActionEvent event) throws IOException {
        changeScene(event, "Student/ViewQuestionForm.fxml", "Student - Question Form");
    }

    @FXML
    public void clickStudentReportFrom(ActionEvent event) throws IOException {
        changeScene(event, "Student/ProblemForm.fxml", "Student - Report Problem");
    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "Student Management System - Login");
    }

    @FXML
    public void clickStudentMCQ(ActionEvent event) throws IOException {
        changeScene(event, "Student/MCQ.fxml", "Student - Quizzes");
    }
}
