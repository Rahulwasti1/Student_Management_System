package com.example.assignment.Admin;

import com.example.assignment.Classes.Teacher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.updateCSV;
import static com.example.assignment.Static.PasswordUtils.hashPassword;

public class EditTeacherFormController implements Initializable {
    @FXML
    private TextField teacherIdField, nameField, numberField, emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> genderCombo;

    @FXML
    private Label idErrorLabel, nameErrorLabel, genderErrorLabel, numberErrorLabel, emailErrorLabel, passwordErrorLabel;

    @FXML
    private Button addButton;

    private String hashPwd;

    public void setTeacher(Teacher teacher) {
        this.teacherIdField.setDisable(true);
        this.teacherIdField.setText(teacher.getId());
        this.nameField.setText(teacher.getName());
        this.genderCombo.setValue(teacher.getGender());
        this.numberField.setText(teacher.getNumber());
        this.emailField.setText(teacher.getEmail());
        this.passwordField.setText("");
        this.hashPwd = teacher.getPassword();
    }

    @FXML
    public void onAddTeacher() throws IOException {
        String teacherId = teacherIdField.getText(),
                name = nameField.getText(),
                gender = genderCombo.getValue(),
                number = numberField.getText(),
                email = emailField.getText(),
                password = passwordField.getText().isEmpty() ? hashPwd : hashPassword(passwordField.getText());
        boolean areFieldsFilled = !teacherId.isEmpty() && !name.isEmpty() && !gender.isEmpty() && (!number.isEmpty() && number.matches("\\d{10}")) && !email.isEmpty() && !password.isEmpty();
        boolean isRecordAdded;

        if (!areFieldsFilled) {
            if (teacherId.isEmpty()) {
                idErrorLabel.setText("This is a required field.");
            } else {
                idErrorLabel.setText("");
            }
            if (name.isEmpty()) {
                nameErrorLabel.setText("This is a required field.");
            } else {
                nameErrorLabel.setText("");
            }
            if (gender == null || gender.isEmpty()) {
                genderErrorLabel.setText("This is a required field.");
            } else {
                genderErrorLabel.setText("");
            }
            if (number.length() != 10) {
                numberErrorLabel.setText("Please enter a valid phone number.");
            } else {
                numberErrorLabel.setText("");
            }
            if (!email.matches("[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}")) {
                emailErrorLabel.setText("Please enter a valid email.");
            } else {
                emailErrorLabel.setText("");
            }
            if (password.length() < 8) {
                passwordErrorLabel.setText("Passwords must be greater than 8 characters.");
            } else {
                passwordErrorLabel.setText("");
            }
        } else {
            String[] data = new String[]{teacherId, name, gender, number, email, password};
            isRecordAdded = updateCSV("./csv_files/add_teacher_form.csv", headersMap.get("add_teacher_form.csv"), teacherId, data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            }
        }
    }

    @FXML
    public void onCancel() {
        ((Stage) addButton.getScene().getWindow()).close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.genderCombo.getItems().addAll("Male", "Female");
    }
}
