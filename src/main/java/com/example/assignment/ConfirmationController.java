package com.example.assignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConfirmationController {
    @FXML
    Button okayButton;

    @FXML
    public void onOkay() {
        ((Stage) okayButton.getScene().getWindow()).close();
    }
}
