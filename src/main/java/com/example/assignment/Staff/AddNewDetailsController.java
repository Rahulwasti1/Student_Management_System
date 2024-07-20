package com.example.assignment.Staff;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.appendCSV;

public class AddNewDetailsController implements Initializable {
    @FXML
    private Label idErrorLabel, nameErrorLabel, bookNameErrorLabel, bookNumberErrorLabel, statusErrorLabel;
    @FXML
    private ComboBox<String> statusCombo;
    @FXML
    private TextField studentIdField, nameField, bookNameField, bookNumberField;
    @FXML
    private Button addButton;

    @FXML
    public void onAddDetails() {
        String studentId = studentIdField.getText(),
                studentName = nameField.getText(),
                bookName = bookNameField.getText(),
                bookNumber = bookNumberField.getText(),
                bookStatus = statusCombo.getValue();
        boolean allFieldsFilled = !studentId.isEmpty() && !bookName.isEmpty() && !bookNumber.isEmpty() && bookStatus != null;

//        SURELY THERE MSUT BE A BETTER WAY TO DO THIS???
        if (!allFieldsFilled) {
            if (studentId.isEmpty()) {
                idErrorLabel.setText("This field is required.");
            } else {
                idErrorLabel.setText("");
            }
            if (studentName.isEmpty()) {
                nameErrorLabel.setText("This field is required.");
            } else {
                nameErrorLabel.setText("");
            }
            if (bookName.isEmpty()) {
                bookNameErrorLabel.setText("This field is required.");
            } else {
                bookNameErrorLabel.setText("");
            }
            if (bookNumber.isEmpty()) {
                bookNumberErrorLabel.setText("This field is required.");
            } else {
                bookNumberErrorLabel.setText("");
            }
            if (bookStatus == null || bookStatus.isEmpty()) {
                statusErrorLabel.setText("This field is required.");
            } else {
                statusErrorLabel.setText("");
            }
        } else {
            String[] data = new String[]{studentId, studentName, bookName, bookNumber, bookStatus};
            boolean isRecordAdded = appendCSV("./csv_files/add_details.csv", data);

            if (isRecordAdded) {
                ((Stage) addButton.getScene().getWindow()).close();
            }
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statusCombo.getItems().addAll("Pending", "Returned");
    }
}
