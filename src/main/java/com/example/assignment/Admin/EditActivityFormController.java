package com.example.assignment.Admin;

import com.example.assignment.Classes.Activity;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.updateCSV;

public class EditActivityFormController {
    @FXML
    private TextField activityIdField, activityTypeField;
    @FXML
    private DatePicker activityDateField;
    @FXML
    private Button addButton, cancelButton;
    @FXML
    private Label idErrorLabel, typeErrorLabel, dateErrorLabel;

    public void setActivity(Activity activity) {
        this.activityIdField.setDisable(true);
        this.activityIdField.setText(activity.getId());
        this.activityTypeField.setText(activity.getType());
        this.activityDateField.setValue(LocalDate.parse(activity.getDate()));
    }

    @FXML
    public void onAddActivity() throws IOException {
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

            boolean isRecordAdded = updateCSV("./csv_files/add_activities_form.csv", headersMap.get("add_activities_form.csv"), activityId, data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            }
        }
    }

    public void onCancel() {
        ((Stage) addButton.getScene().getWindow()).close();
    }

}
