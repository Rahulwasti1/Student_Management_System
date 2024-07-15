package com.example.assignment;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.io.IOException;

import static com.example.assignment.Uses.changeScene;

public class Login {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    @FXML
    public void handleAdminLogin(ActionEvent event) throws IOException {
        changeScene(event, "AdminDashboard.fxml", "LOGIN PAGE");
    }

//    @FXML
//    public void handleLogin(ActionEvent event) throws IOException {
//        String email = emailField.getText();
//        String password = passwordField.getText();
//
//        if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
//            changeScene(event, "AdminDashboard.fxml", "Admin Dashboard");
//        } else {
//            errorMessage.setText("Wrong email or password");
//        }
//    }
}