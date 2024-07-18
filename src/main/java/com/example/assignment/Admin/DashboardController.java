package com.example.assignment.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import static com.example.assignment.Uses.changeScene;

public class DashboardController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickAdminDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Admin/Dashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickManageStudent(ActionEvent event) throws IOException {
        changeScene(event, "Admin/ManageStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickManageTeacher(ActionEvent event) throws IOException {
        changeScene(event, "Admin/ManageTeacher.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickManageStaff(ActionEvent event) throws IOException {
        changeScene(event, "Admin/ManageStaff.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickManageActivities(ActionEvent event) throws IOException {
        changeScene(event, "Admin/ManageActivities.fxml", "STUDENT MANAGEMENT SYSTEM");
    }


}