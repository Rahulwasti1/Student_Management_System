package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.Uses.changeScene;

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
        String role = roleCombo.getValue();
        switch (role) {
            case "Student":
                changeScene(event, "Student/Dashboard.fxml", "Student Dashboard");
                break;

            case "Teacher":
                changeScene(event, "Teacher/Dashboard.fxml", "Teacher Dashboard");
                break;

            case "Admin":
                changeScene(event, "Admin/Dashboard.fxml", "Admin Dashboard");
                break;

            case "Staff":
                changeScene(event, "Staff/Dashboard.fxml", "Staff Dashboard");
                break;

            default:
                break;

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.roleCombo.getItems().addAll("Student", "Teacher", "Staff", "Admin");
        this.roleCombo.setValue("Student");
    }

//    @FXML
//    public void handleLogin(ActionEvent event) throws IOException {
//        String email = emailField.getText();
//        String password = passwordField.getText();
//
//        if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
//            changeScene(event, String.format("%s/Dashboard.fxml", roleCombo.getValue()), "Admin Dashboard");
//        } else {
//            errorMessage.setText("Wrong email or password");
//        }
//    }
}