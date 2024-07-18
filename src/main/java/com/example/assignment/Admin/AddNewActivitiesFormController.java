package com.example.assignment.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

import static com.example.assignment.Uses.appendCSV;

public class AddNewActivitiesFormController {
    @FXML
    TextField activityIdField, activityTypeField;

    @FXML
    DatePicker activityDateField;

    @FXML
    public void onAddActivity() {
        String activityId = activityIdField.getText(),
                activityType = activityTypeField.getText();
        LocalDate activityDate = activityDateField.getValue();

        String[] data = new String[]{activityId, activityType, activityDate.toString()};

        appendCSV("./csv_files/add_activities_form.csv", data);
    }
}
