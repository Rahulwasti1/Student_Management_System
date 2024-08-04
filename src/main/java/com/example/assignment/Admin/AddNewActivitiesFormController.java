package com.example.assignment.Admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.appendCSV;
import static com.example.assignment.Static.RandomIDGenerator.generateRandomEightDigits;

public class AddNewActivitiesFormController implements Initializable {
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
            } else {
                dateErrorLabel.setText("");
            }
        } else {
            String[] data = new String[]{activityId, activityType, activityDate.toString()};

            boolean isRecordAdded = appendCSV("./csv_files/add_activities_form.csv", data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            }
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.activityIdField.setDisable(true);
        this.activityIdField.setText("act" + generateRandomEightDigits());
    }
}
