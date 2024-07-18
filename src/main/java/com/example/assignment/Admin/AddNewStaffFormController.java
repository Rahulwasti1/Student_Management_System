package com.example.assignment.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.appendCSV;

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
    private Label errorLabel;

    @FXML
    public void onAddStaff() {
        String staffId = staffIdField.getText(),
                name = nameField.getText(),
                gender = genderCombo.getValue(),
                number = numberField.getText(),
                email = emailField.getText(),
                password = passwordField.getText();

        boolean areFieldsFilled = !staffId.isEmpty() && !name.isEmpty() && !number.isEmpty() && !email.isEmpty() && !password.isEmpty();
        boolean isRecordAdded = false;

        if (areFieldsFilled) {
            errorLabel.setText("");
            String[] data = new String[]{staffId, name, gender, number, email, password};
            isRecordAdded = appendCSV("./csv_files/add_staff_form.csv", data);


            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            } else {
                errorLabel.setText("Failed to write data. Please try again!");
            }
        } else {
            errorLabel.setText("Please fill in all the fields.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.genderCombo.getItems().addAll("Male", "Female");
    }
}
