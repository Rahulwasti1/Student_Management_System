package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.assignment.Uses.changeScene;

public class AdminManageActivities {

    @FXML
    public void clickAdminDashboard(ActionEvent event) throws IOException {
        changeScene(event, "AdminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickManageStudent(ActionEvent event) throws IOException {
        changeScene(event, "Admin_ManageStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickManageTeacher(ActionEvent event) throws IOException {
        changeScene(event, "Admin_ManageTeacher.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickManageStaff(ActionEvent event) throws IOException {
        changeScene(event, "Admin_ManageStaff.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickManageActivities(ActionEvent event) throws IOException {
        changeScene(event, "Admin_ManageActivities.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
