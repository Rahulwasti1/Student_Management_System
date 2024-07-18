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
        changeScene(event, "Admin/Dashboard.fxml", "LOGIN PAGE");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.roleCombo.getItems().addAll("Student", "Teacher", "Admin");
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