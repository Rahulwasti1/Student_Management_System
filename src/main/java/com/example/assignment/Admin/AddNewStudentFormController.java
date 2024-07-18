package com.example.assignment.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Uses.appendCSV;
import static com.example.assignment.Uses.changeScene;

// Java Doc

/**
 * <h1><code>AdminAddNewStudentForm.java</code></h1>
 * <p>
 * Controller file to manage new students.
 * </p>
 */

public class AddNewStudentFormController implements Initializable {

    @FXML
    TextField studentIdField, firstNameField, lastNameField, numberField, emailField, facultyField;
    @FXML
    PasswordField passwordField;

    @FXML
    ComboBox<String> genderCombo;

    @FXML
    public void clickManageStudent(ActionEvent event) throws IOException {
        changeScene(event, "ManageStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }


    public void onAddStudent() {
        String studentId = this.studentIdField.getText(),
                firstName = this.firstNameField.getText(),
                lastName = this.lastNameField.getText(),
                gender = this.genderCombo.getValue(),
                phoneNumber = this.numberField.getText(),
                email = this.emailField.getText(),
                faculty = this.facultyField.getText();

//        refer to the headers for positioning
        String[] data = new String[]{studentId, firstName, lastName, gender, phoneNumber, email, faculty};

        appendCSV("csv_files/add_student_form.csv", data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//       in 2024 too :/
        String[] genders = {"Male", "Female"};
        this.genderCombo.getItems().addAll(genders);
    }
}
