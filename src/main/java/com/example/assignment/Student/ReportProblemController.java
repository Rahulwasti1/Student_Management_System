package com.example.assignment.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.Uses.changeScene;
import static com.example.assignment.Static.Uses.currentUser;

public class ReportProblemController implements Initializable {
    @FXML
    TextField problemId, studentId, creatorId;

    @FXML
    TextArea problemText;

    @FXML
    public void clickStudentDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Student/Dashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentViewProfile(ActionEvent event) throws IOException {
        changeScene(event, "Student/ViewProfile.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentViewCourse(ActionEvent event) throws IOException {
        changeScene(event, "Student/ViewCourse.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentQuestionFrom(ActionEvent event) throws IOException {
        changeScene(event, "Student/QuestionForm.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentReportFrom(ActionEvent event) throws IOException {
        changeScene(event, "Student/ReportProblem.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickStudentMCQ(ActionEvent event) throws IOException {
        changeScene(event, "Student/MCQ.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "LOGIN");

    }

    @FXML
    public void onSend() {
        String problemId = this.problemId.getText(),
                problemText = this.problemText.getText();

        boolean allFieldsFilled = !problemId.isEmpty() && !problemText.isEmpty();

        if (allFieldsFilled) {
            this.problemId.setText("");
            this.problemText.setText("");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setText(currentUser.getId());
        creatorId.setText(currentUser.getFirstName() + " " + currentUser.getLastName());
    }
}
