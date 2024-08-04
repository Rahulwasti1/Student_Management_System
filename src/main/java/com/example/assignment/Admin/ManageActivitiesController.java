package com.example.assignment.Admin;

import com.example.assignment.Classes.Activity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.readCSV;
import static com.example.assignment.Static.Uses.changeScene;
import static com.example.assignment.Static.Uses.createPopup;

public class ManageActivitiesController implements Initializable {
    @FXML
    TableView<Activity> manageActivitiesTable;

    @FXML
    TableColumn<Activity, String> activityId, activityType, activityDate;

    @FXML
    TableColumn<Activity, HBox> activityAction;

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
    public void onAddActivity(ActionEvent event) throws IOException {
        createPopup(event, "Admin/AddNewActivitiesForm.fxml", "Admin: Add a new activity");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        activityId.setCellValueFactory(new PropertyValueFactory<>("id"));
        activityType.setCellValueFactory(new PropertyValueFactory<>("type"));
        activityDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        activityAction.setCellValueFactory(new PropertyValueFactory<>("action"));

        try {
            List<Activity> data = readCSV("./csv_files/add_activities_form.csv", headersMap.get("add_activities_form.csv"), Activity.class);

            for (Activity activity : data) {
                manageActivitiesTable.getItems().add(activity);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.getCause();
        }
    }
}
