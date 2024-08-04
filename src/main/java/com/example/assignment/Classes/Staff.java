package com.example.assignment.Classes;

import com.example.assignment.Admin.EditStaffFormController;
import com.example.assignment.DeleteConfirmationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Staff extends User {
    private final HBox action;
    private String number;
    private String name;

    public Staff(String id, String name, String gender, String number, String email, String password) {
        this.setId(id);
        this.name = name;
        this.number = number;
        this.setGender(gender);
        this.setEmail(email);
        this.setPassword(password);

        this.action = this.createActionButtons();
    }

    private HBox createActionButtons() {
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        editButton.setOnAction(this::onEditPopup);
        deleteButton.setOnAction(this::onDeletePopup);

        HBox action = new HBox(5);
        action.getChildren().addAll(editButton, deleteButton);

        return action;
    }

    private void onEditPopup(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/assignment/Admin/EditStaffForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            EditStaffFormController controller = fxmlLoader.getController();
            controller.setStaff(this);

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Edit Activity");
            popupStage.setScene(scene);
            popupStage.setResizable(false);
            popupStage.showAndWait();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void onDeletePopup(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/assignment/DeleteConfirmation.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            DeleteConfirmationController controller = fxmlLoader.getController();
            controller.setEntity("./csv_files/add_staff_form.csv", this.getId());

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Delete Confirmation");
            popupStage.setScene(scene);
            popupStage.setResizable(false);
            popupStage.showAndWait();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HBox getAction() {
        return action;
    }
}
