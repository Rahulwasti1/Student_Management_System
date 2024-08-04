package com.example.assignment.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.appendCSV;
import static com.example.assignment.Static.PasswordUtils.hashPassword;
import static com.example.assignment.Static.RandomIDGenerator.generateRandomEightDigits;

public class AddNewStaffFormController implements Initializable {
    @FXML
    private TextField staffIdField, nameField, numberField, emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> genderCombo;

    @FXML
    private Button addButton;

    @FXML
    private Label idErrorLabel, nameErrorLabel, genderErrorLabel, numberErrorLabel, emailErrorLabel, passwordErrorLabel;

    @FXML
    public void onAddStaff() {
        String staffId = staffIdField.getText(),
                name = nameField.getText(),
                gender = genderCombo.getValue(),
                number = numberField.getText(),
                email = emailField.getText(),
                password = passwordField.getText();

        boolean areFieldsFilled = !staffId.isEmpty() && !gender.isEmpty() && !name.isEmpty() &&
                (!number.isEmpty() && number.matches("^\\d{10}")) &&
                !email.isEmpty() && !password.isEmpty();
        boolean isRecordAdded;

        if (!areFieldsFilled) {
            if (staffId.isEmpty()) {
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
            String[] data = new String[]{staffId, name, gender, number, email, hashPassword(password)};
            isRecordAdded = appendCSV("./csv_files/add_staff_form.csv", data);


            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.staffIdField.setDisable(true);
        this.staffIdField.setText("sta" + generateRandomEightDigits());
        this.genderCombo.getItems().addAll("Male", "Female");
    }
}
