package com.example.assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.assignment.Uses.changeScene;

public class AdminAddNewStudentForm {

    @FXML
    public void clickManageStudent(ActionEvent event) throws IOException {
        changeScene(event, "Admin_ManageStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

}
