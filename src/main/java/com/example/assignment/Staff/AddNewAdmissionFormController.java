package com.example.assignment.Staff;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.appendCSV;

public class AddNewAdmissionFormController implements Initializable {
    @FXML
    TextField studentIdField, nameField, emailField;

    @FXML
    DatePicker applicationDateField;

    @FXML
    ComboBox<String> statusCombo;

    @FXML
    Button addButton;

    @FXML
    Label idErrorLabel, nameErrorLabel, dateErrorLabel, emailErrorLabel, statusErrorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statusCombo.getItems().setAll("Approved", "Pending");
    }

    @FXML
    public void onAddAdmission() {
        String studentId = studentIdField.getText(),
                name = nameField.getText(),
                email = emailField.getText(),
                status = statusCombo.getValue();
        LocalDate applicationDate = applicationDateField.getValue();

        boolean areFieldsFilled = !studentId.isEmpty() && !name.isEmpty() && (status != null)
                && !email.isEmpty() && applicationDate != null;

        if (!areFieldsFilled) {
            if (studentId.isEmpty()) {
                idErrorLabel.setText("This field is required.");
            } else {
                idErrorLabel.setText("");
            }
            if (name.isEmpty()) {
                nameErrorLabel.setText("This field is required.");
            } else if (name.length() < 3) {
                nameErrorLabel.setText("Name length must be greater than 3.");
            } else {
                nameErrorLabel.setText("");
            }
            if (email.isEmpty()) {
                emailErrorLabel.setText("This field is required.");
            } else if (email.matches("[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}")) {
                emailErrorLabel.setText("Please enter a valid email.");
            } else {
                emailErrorLabel.setText("");
            }
            if (status == null) {
                statusErrorLabel.setText("This field is required.");
            } else {
                statusErrorLabel.setText("");
            }
            if (applicationDate == null) {
                dateErrorLabel.setText("This field is required.");
            } else {
                dateErrorLabel.setText("");
            }
        } else {
            String[] data = new String[]{studentId, name, email, applicationDate.toString(), status};
            boolean isRecordAdded = appendCSV("./csv_files/add_admission_form.csv", data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            }
        }
    }
}
