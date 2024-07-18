package com.example.assignment.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Uses.appendCSV;

public class AddNewStaffFormController implements Initializable {
    @FXML
    private TextField staffIdField, nameField, numberField, emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> genderCombo;

    @FXML
    public void onAddStaff() {
        String staffId = staffIdField.getText(),
                name = nameField.getText(),
                gender = genderCombo.getValue(),
                number = numberField.getText(),
                email = emailField.getText(),
                password = passwordField.getText();

        String[] data = new String[]{staffId, name, gender, number, email, password};
        appendCSV(".csv_files/add_staff_form.csv", data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.genderCombo.getItems().addAll("Male", "Female");
    }
}
