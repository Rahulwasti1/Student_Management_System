package com.example.assignment.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.readCSV;
import static com.example.assignment.Static.Uses.changeScene;
import static com.example.assignment.Static.Uses.createPopup;

public class ManageStudentController implements Initializable {
    @FXML
    TableView manageStudentTable;

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

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void onAddStudent(ActionEvent event) throws IOException {
        createPopup("Admin/AddNewStudentForm.fxml", "Admin: Add new student");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            List<String[]> data = readCSV("./csv_files/add_student_form.csv", headersMap.get("add_student_form.csv"));
            for (String[] row : data) {
//                what to do
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
