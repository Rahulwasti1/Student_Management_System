package com.example.assignment.Student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;

import static com.example.assignment.Static.CSVUtils.appendCSV;
import static com.example.assignment.Static.Uses.changeScene;

public class QuestionFormController {
    @FXML
    TextField qnId, qnPosition, qnText;

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
    public void onSend() {
        String qnId = this.qnId.getText(),
                qnPosition = this.qnPosition.getText(),
                qnText = this.qnText.getText();

        boolean allFieldFilled = !qnId.isEmpty() && !qnPosition.isEmpty() && !qnText.isEmpty();

        if (allFieldFilled) {
            String[] data = new String[]{qnId, qnPosition, qnText};
            boolean isRecordWritten = appendCSV("./csv_files/add_question_form.csv", data);

            if (isRecordWritten) {
                this.qnId.setText("");
                this.qnPosition.setText("");
                this.qnText.setText("");
            }
        }
    }
}
