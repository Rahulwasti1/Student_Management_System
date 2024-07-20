package com.example.assignment.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

import static com.example.assignment.Static.CSVUtils.appendCSV;

public class AddNewActivitiesFormController {
    @FXML
    private TextField activityIdField, activityTypeField;

    @FXML
    private DatePicker activityDateField;

    @FXML
    private Button addButton;

    @FXML
    private Label idErrorLabel, typeErrorLabel, dateErrorLabel;

    @FXML
    public void onAddActivity() {
        String activityId = activityIdField.getText(),
                activityType = activityTypeField.getText();
        LocalDate activityDate = activityDateField.getValue();


        boolean areFieldsFilled = !activityId.isEmpty() && !activityType.isEmpty() &&
                (activityDate != null && !activityDate.isBefore(LocalDate.now()));
        boolean isRecordAdded;

        if (!areFieldsFilled) {
            if (activityId.isEmpty()) {
                idErrorLabel.setText("This is a required field.");
            } else {
                idErrorLabel.setText("");
            }
            if (activityType.isEmpty()) {
                typeErrorLabel.setText("This is a required field.");
            } else {
                typeErrorLabel.setText("");
            }
            if (activityDate == null) {
                dateErrorLabel.setText("This is a required field.");
            } else if (activityDate.isBefore(LocalDate.now())) {
                dateErrorLabel.setText("Newer activities can't be in the past.");
            }
        } else {
            String[] data = new String[]{activityId, activityType, activityDate.toString()};

            isRecordAdded = appendCSV("./csv_files/add_activities_form.csv", data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            }
        }


    }
}
