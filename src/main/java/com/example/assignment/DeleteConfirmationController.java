package com.example.assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static com.example.assignment.Static.CSVUtils.deleteCSV;

public class DeleteConfirmationController {
    @FXML
    Button deleteButton;

    private String filename;
    private String targetId;

    public void setEntity(String filename, String id) {
        this.filename = filename;
        this.targetId = id;
    }

    @FXML
    public void onDelete() {
        deleteCSV(filename, targetId);

        ((Stage) deleteButton.getScene().getWindow()).close();
    }

    @FXML
    public void onCancel() {
        ((Stage) deleteButton.getScene().getWindow()).close();
    }
}
