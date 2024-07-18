package com.example.assignment.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.appendCSV;

// Java Doc

/**
 * <h1><code>AdminAddNewStudentForm.java</code></h1>
 * <p>
 * Controller file to manage new students.
 * </p>
 */

public class AddNewStudentFormController implements Initializable {

    @FXML
    private TextField studentIdField, firstNameField, lastNameField, numberField, emailField, facultyField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> genderCombo;

    @FXML
    private Button addButton;

    @FXML
    private Label errorLabel;

    @FXML
    public void onAddStudent() {
        String studentId = this.studentIdField.getText(),
                firstName = this.firstNameField.getText(),
                lastName = this.lastNameField.getText(),
                gender = this.genderCombo.getValue(),
                phoneNumber = this.numberField.getText(),
                email = this.emailField.getText(),
                faculty = this.facultyField.getText(),
                password = this.passwordField.getText();

        boolean areFieldsFilled = !studentId.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !gender.isEmpty() && !phoneNumber.isEmpty() && !email.isEmpty() && !faculty.isEmpty() && !password.isEmpty();
        boolean isRecordAdded = false;

        if (areFieldsFilled) {
            errorLabel.setText("");
//        refer to the headers for positioning
            String[] data = new String[]{studentId, firstName, lastName, gender, phoneNumber, email, faculty, password};
            isRecordAdded = appendCSV("csv_files/add_student_form.csv", data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            } else {
                errorLabel.setText("Failed to write data. Please try again!");
            }
        } else {
            errorLabel.setText("Please fill in all the fields!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//       in 2024 too :/
        String[] genders = {"Male", "Female"};
        this.genderCombo.getItems().addAll(genders);
    }
}
