package com.example.assignment.Admin;

import com.example.assignment.Classes.Staff;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class ManageStaffController implements Initializable {
    @FXML
    TableView<Staff> manageStaffTable;

    @FXML
    TableColumn<Staff, String> staffId, staffName, staffGender, staffNumber, staffEmail;

    @FXML
    TableColumn<Staff, ?> staffAction;

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
    public void onAddStaff(ActionEvent event) throws IOException {
        createPopup(event, "Admin/AddNewStaffForm.fxml", "Admin: Add a new staff");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        staffId.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffName.setCellValueFactory(new PropertyValueFactory<>("name"));
        staffGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        staffEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        staffNumber.setCellValueFactory(new PropertyValueFactory<>("number"));

        try {
            List<Staff> data = readCSV("./csv_files/add_staff_form.csv", headersMap.get("add_staff_form.csv"), Staff.class);

            for (Staff staff : data) {
                manageStaffTable.getItems().add(staff);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getStackTrace());
            e.getCause();
        }
    }
}
