package com.example.assignment.Staff;

import com.example.assignment.Classes.Admission;
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

public class ManageAdmissionsController implements Initializable {
    @FXML
    TableView<Admission> manageAdmissionsTable;

    @FXML
    TableColumn<Admission, String> id, name, applicationDate, email, faculty, status;

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "STUDENT MANAGEMENT SYSTEM - LOGIN");
    }

    @FXML
    public void onAddAdmissions(ActionEvent event) throws IOException {
        createPopup(event, "Staff/AddNewAdmission.fxml", "Add New Admission");
    }

    @FXML
    public void onClickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Staff/Dashboard.fxml", "Staff - Dashboard");
    }

    @FXML
    public void onClickLibrary(ActionEvent event) throws IOException {
        changeScene(event, "Staff/ManageLibrary.fxml", "Staff - Manage Library");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        applicationDate.setCellValueFactory(new PropertyValueFactory<>("applicationDate"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        faculty.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        try {
            List<Admission> data = readCSV("./csv_files/add_admission_form.csv", headersMap.get("add_admission_form.csv"), Admission.class);
            manageAdmissionsTable.getItems().addAll(data);

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.getCause();
        }
    }
}
