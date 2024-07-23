package com.example.assignment.Student;

import com.example.assignment.Classes.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.updateCSV;
import static com.example.assignment.Static.PasswordUtils.checkPassword;
import static com.example.assignment.Static.PasswordUtils.hashPassword;
import static com.example.assignment.Static.Uses.*;

public class ViewProfileController {
    @FXML
    TextField email, password, newPassword;

    @FXML
    Button saveBtn;

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
    public void onSave(ActionEvent event) throws IOException {
        String email = this.email.getText(),
                password = this.password.getText(),
                newPassword = this.newPassword.getText();

        if (email.equals(currentUser.getEmail()) && checkPassword(password, currentUser.getPassword())) {
            currentUser.setPassword(newPassword);
            String[] data = new String[]{
                    currentUser.getId(),
                    currentUser.getFirstName(),
                    currentUser.getLastName(),
                    currentUser.getGender(),
                    ((Student) currentUser).getPhoneNumber(),
                    currentUser.getEmail(),
                    ((Student) currentUser).getFaculty(),
                    hashPassword(newPassword)
            };
            updateCSV("./csv_files/add_student_form.csv", headersMap.get("add_student_form.csv"), currentUser.getId(), data);
            createPopup(event, "Confirmation.fxml", "Successfully updated password!");
        }
    }

    @FXML
    public void onCancel() {
        this.email.setText("");
        this.password.setText("");
        this.newPassword.setText("");
    }
}
