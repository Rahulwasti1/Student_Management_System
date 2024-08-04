package com.example.assignment.Teacher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.assignment.Static.CSVUtils.appendCSV;
import static com.example.assignment.Static.Uses.changeScene;

public class CreateMCQController {
    @FXML
    TextField quizId, quizText, option1, option2, option3, option4;

    @FXML
    Label errorLabel;

    @FXML
    Button submitButton;

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

    @FXML
    public void onSubmit() {
        String quizId = this.quizId.getText(),
                quizQn = this.quizText.getText(),
                option1 = this.option1.getText(),
                option2 = this.option2.getText(),
                option3 = this.option3.getText(),
                option4 = this.option4.getText();

        boolean allFieldsFilled = !quizId.isEmpty() && !quizQn.isEmpty() &&
                !option1.isEmpty() && !option2.isEmpty() && !option3.isEmpty() &&
                !option4.isEmpty();

        if (!allFieldsFilled) {
            this.errorLabel.setStyle("-fx-text-fill: 'red'; -fx-font-size: 12px;");
            errorLabel.setText("Please fill all the fields.");
        } else {
            errorLabel.setText("");
            String[] data = new String[]{quizId, quizQn, option1, option2, option3, option4};
            boolean recordWritten = appendCSV("./csv_files/add_quiz_form.csv", data);

            if (recordWritten) {
                this.quizId.setText("");
                this.quizText.setText("");
                this.option1.setText("");
                this.option2.setText("");
                this.option3.setText("");
                this.option4.setText("");

                this.errorLabel.setStyle("-fx-text-fill: 'green'; -fx-font-size: 18px;");
                this.errorLabel.setText("MCQ Added!");
            } else {
                errorLabel.setText("Failed to create MCQ. Try again!");
            }
        }
    }
}
