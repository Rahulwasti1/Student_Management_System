package com.example.assignment.Admin;

import com.example.assignment.Classes.Student;
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

public class ManageStudentController implements Initializable {
    @FXML
    TableView<Student> manageStudentTable;

    @FXML
    TableColumn<Student, String> studentId, studentName, studentGender, studentNumber, studentPwd, studentEmail, studentFaculty;

    @FXML
    TableColumn<Student, Button> studentAction;

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
        createPopup(event, "Admin/AddNewStudentForm.fxml", "Admin: Add new student");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        studentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        studentNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        studentEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        studentFaculty.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        studentPwd.setCellValueFactory(new PropertyValueFactory<>("password"));
        studentAction.setCellValueFactory(new PropertyValueFactory<>("action"));
        try {
            List<Student> data = readCSV("./csv_files/add_student_form.csv", headersMap.get("add_student_form.csv"), Student.class);
            for (Student student : data) {
                manageStudentTable.getItems().add(student);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
        }

    }
}
