package com.example.assignment;

import com.example.assignment.Classes.Staff;
import com.example.assignment.Classes.Student;
import com.example.assignment.Classes.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.Uses.changeScene;
import static com.example.assignment.Static.Uses.validateLogin;

public class Login implements Initializable {
    private String roleDashboard;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    @FXML
    private ComboBox<String> roleCombo;

    @FXML
    public void handleAdminLogin(ActionEvent event) throws IOException {
        String email = emailField.getText(),
                password = passwordField.getText();
        if (email.isEmpty() || password.isEmpty()) {
            errorMessage.setText("Missing email or password!");
            return;
        } else {
            errorMessage.setText("");
        }

        String role = roleCombo.getValue();

        boolean validCredentials = false;
        String fxmlPath = "";
        String dashboardTitle = "";

        switch (role) {
            case "Student":
                validCredentials = validateLogin(email, password, "./csv_files/add_student_form.csv", "add_student_form.csv", Student.class);
                fxmlPath = "Student/Dashboard.fxml";
                dashboardTitle = "Student Dashboard";
                break;

            case "Teacher":
                validCredentials = validateLogin(email, password, "./csv_files/add_teacher_form.csv", "add_teacher_form.csv", Teacher.class);
                fxmlPath = "Teacher/Dashboard.fxml";
                dashboardTitle = "Teacher Dashboard";
                break;

            case "Staff":
                validCredentials = validateLogin(email, password, "./csv_files/add_staff_form.csv", "add_staff_form.csv", Staff.class);
                fxmlPath = "Staff/Dashboard.fxml";
                dashboardTitle = "Staff Dashboard";
                break;

            case "Admin":
                if (email.equals("admin") && password.equals("admin420")) {
                    validCredentials = true;
                    fxmlPath = "Admin/Dashboard.fxml";
                    dashboardTitle = "Admin Dashboard";
                } else {
                    errorMessage.setText("Invalid credentials.");
                }
                break;

            default:
                errorMessage.setText("Invalid role.");
                break;
        }

        if (validCredentials) {
            changeScene(event, fxmlPath, dashboardTitle);
        } else if (!role.equals("Admin")) {
            errorMessage.setText("Invalid credentials.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.roleCombo.getItems().addAll("Student", "Teacher", "Staff", "Admin");
        this.roleCombo.setValue("Student");
    }
}