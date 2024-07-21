package com.example.assignment.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.assignment.Static.Uses.changeScene;

public class ViewCourseController {
    @FXML
    public void clickEnrolledCourse(ActionEvent event) throws IOException {
        changeScene(event, "Student/EnrolledCourse.fxml", "Student - Enrolled Courses");
    }

    public void clickStudentDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Student/Dashboard.fxml", "Student - Dashboard");
    }

    public void clickStudentViewProfile(ActionEvent event) throws IOException {
        changeScene(event, "Student/ViewProfile.fxml", "Student - Profile");

    }

    public void clickStudentViewCourse(ActionEvent event) throws IOException {
        changeScene(event, "Student/ViewCourse.fxml", "Student - Courses");
    }

    public void clickStudentQuestionFrom(ActionEvent event) throws IOException {
        changeScene(event, "Student/QuestionForm.fxml", "Student - Question Form");
    }

    public void clickStudentReportFrom(ActionEvent event) throws IOException {
        changeScene(event, "Student/ReportProblem.fxml", "Student - Report Problem");
    }

    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "Student Management System - Login ");
    }

    public void clickStudentMCQ(ActionEvent event) throws IOException {
        changeScene(event, "Student/MCQ.fxml", "Student - Quiz");
    }
}
