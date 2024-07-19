package com.example.assignment.Admin;

import com.example.assignment.Classes.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.readCSV;
import static com.example.assignment.Static.Uses.changeScene;
import static com.example.assignment.Static.Uses.createPopup;


public class ManageTeacherController implements Initializable {
    @FXML
    TableView<Teacher> manageTeacherTable;

    @FXML
    TableColumn<Teacher, String> teacherId, teacherName, teacherGender, teacherNumber, teacherSubject, teacherEmail;

    @FXML
    TableColumn<Teacher, Button> teacherAction;

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

    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void onAddTeacher() throws IOException {
        createPopup("Admin/AddNewTeacherForm.fxml", "Admin: Add a new teacher");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teacherId.setCellValueFactory(new PropertyValueFactory<>("id"));
        teacherName.setCellValueFactory(new PropertyValueFactory<>("name"));
        teacherEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        teacherGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        teacherNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        teacherSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));

        try {
            List<Teacher> data = readCSV("./csv_files/add_teacher_form.csv", headersMap.get("add_teacher_form.csv"), Teacher.class);

            for (Teacher teacher : data) {
                manageTeacherTable.getItems().add(teacher);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.getCause();
        }

    }
}
