package com.example.assignment.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Uses.appendCSV;

public class AddNewTeacherFormController implements Initializable {
    @FXML
    TextField teacherIdField, nameField, numberField, emailField;

    @FXML
    PasswordField passwordField;

    @FXML
    ComboBox<String> genderCombo;

    @FXML
    public void onAddTeacher() {
        String teacherId = teacherIdField.getText(),
                name = nameField.getText(),
                gender = genderCombo.getValue(),
                number = numberField.getText(),
                email = numberField.getText(),
                password = passwordField.getText();

        String[] data = new String[]{teacherId, name, gender, number, email, password};
        appendCSV("./csv_files/add_teacher_form.csv", data);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.genderCombo.getItems().addAll("Male", "Female");
    }
}
