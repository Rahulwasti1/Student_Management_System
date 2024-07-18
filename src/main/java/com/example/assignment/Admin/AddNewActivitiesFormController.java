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
    private Label errorLabel;

    @FXML
    public void onAddActivity() {
        String activityId = activityIdField.getText(),
                activityType = activityTypeField.getText();
        LocalDate activityDate = activityDateField.getValue();


        boolean areFieldsFilled = !activityId.isEmpty() && !activityType.isEmpty() && !(activityDate == null);
        boolean isRecordAdded = false;

        if (areFieldsFilled) {
            errorLabel.setText("");
            String[] data = new String[]{activityId, activityType, activityDate.toString()};

            isRecordAdded = appendCSV("./csv_files/add_activities_form.csv", data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            } else {
                errorLabel.setText("Failed to write data. Please try again!");
            }
        } else {
            errorLabel.setText("Please fill in all the fields!");
        }


    }
}
