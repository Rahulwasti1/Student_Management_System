package com.example.assignment.Teacher;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.appendCSV;

public class AddNewGradeController implements Initializable {
    @FXML
    ComboBox<String> genderCombo, statusCombo;
    @FXML
    Button addButton;
    @FXML
    private Label idErrorLabel, nameErrorLabel, genderErrorLabel, percentageErrorLabel, emailErrorLabel, statusErrorLabel;
    @FXML
    private TextField studentIdField, nameField, percentageField, emailField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        why would you want to have gender in grades view? and not subject?
        genderCombo.getItems().addAll("Male", "Female");

        statusCombo.getItems().addAll("Passed", "Failed");
    }

    @FXML
    public void onAddGrade() {
        String studentId = studentIdField.getText(),
                name = nameField.getText(),
                gender = genderCombo.getValue(),
                percentage = percentageField.getText(),
                email = emailField.getText(),
                status = statusCombo.getValue();

        boolean allFieldsFilled = !studentId.isEmpty() && !name.isEmpty() && gender != null && !percentage.isEmpty() && !email.isEmpty() && status != null;

        if (!allFieldsFilled) {
            if (studentId.isEmpty()) {
                idErrorLabel.setText("This field is required.");
            } else {
                idErrorLabel.setText("");
            }
            if (name.isEmpty()) {
                nameErrorLabel.setText("This field is required.");
            } else if (name.length() < 3) {
                nameErrorLabel.setText("Name must be greater than 3 characters");
            } else {
                nameErrorLabel.setText("");
            }
            if (gender == null) {
                genderErrorLabel.setText("This field is required.");
            } else {
                genderErrorLabel.setText("");
            }
            try {
                if (percentage.isEmpty()) {
                    percentageErrorLabel.setText("This field is required.");
                } else if (Double.parseDouble(percentage) > 100) {
                    percentageErrorLabel.setText("Invalid percentage.");
                } else {
                    percentageErrorLabel.setText("");
                }
            } catch (Exception e) { // ParseException maybe but ambiguous
                percentageErrorLabel.setText("Please only include numbers.");
            }
            if (email.isEmpty()) {
                emailErrorLabel.setText("This field is required.");
            } else if (!email.matches("[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}")) {
                emailErrorLabel.setText("Please enter a valid email.");
            } else {
                emailErrorLabel.setText("");
            }
            if (status == null) {
                statusErrorLabel.setText("This field is required.");
            } else {
                statusErrorLabel.setText("");
            }


        } else {
            String[] data = new String[]{studentId, name, gender, percentage, email, status};

            boolean isRecordAdded = appendCSV("./csv_files/add_grade_form.csv", data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            }
        }
    }
}
