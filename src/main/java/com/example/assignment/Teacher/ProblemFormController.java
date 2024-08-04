package com.example.assignment.Teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.assignment.Static.Uses.changeScene;

public class ProblemFormController {

    @FXML
    public void clickTeacherDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/Dashboard.fxml", "Teacher - Dashboard");
    }

    @FXML
    public void clickTeacherViewGrades(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/GradeManagement.fxml", "Teacher - Manage Grades");
    }

    @FXML
    public void clickTeacherViewQuestionForm(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/ViewQuestionForm.fxml", "Teacher - Question Form ");
    }

    @FXML
    public void clickTeacherProblemForm(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/ProblemForm.fxml", "Teacher - Problems");
    }

    @FXML
    public void clickTeacherCreateMCQ(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/CreateMCQ.fxml", "Teacher - Create MCQ");
    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "LOGIN");

    }
}
