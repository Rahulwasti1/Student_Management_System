package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.assignment.Uses.appendCSV;
import static com.example.assignment.Uses.changeScene;

// Java Doc

/**
 * <h1><code>AdminAddNewStudentForm.java</code></h1>
 * <p>
 * Controller file to manage new students.
 * </p>
 */

public class AdminAddNewStudentForm {

    @FXML
    TextField studentIdField, firstNameField, lastNameField, numberField, emailField, facultyField;
    @FXML
    PasswordField passwordField;

    @FXML
    public void clickManageStudent(ActionEvent event) throws IOException {
        changeScene(event, "Admin_ManageStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    public void onAddStudent() throws IOException {
        String studentId = this.studentIdField.getText(),
                firstName = this.firstNameField.getText(),
                lastName = this.lastNameField.getText(),
                phoneNumber = this.numberField.getText(),
                email = this.emailField.getText(),
                faculty = this.facultyField.getText();

//        refer to the headers for positioning
        String[] data = new String[]{studentId, firstName, lastName, phoneNumber, email, faculty};

        appendCSV("test.csv", data);
    }

}
