package com.example.assignment.Classes;

import com.example.assignment.Admin.EditActivityFormController;
import com.example.assignment.DeleteConfirmationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Activity {
    private final HBox action;
    private String id;
    private String type;
    private String date;

    public Activity(String id, String type, String date) {
        this.id = id;
        this.type = type;
        this.date = date;

        this.action = this.createActionButtons();
    }

    private HBox createActionButtons() {
        HBox action = new HBox(5);
        Button editButton = new Button("Edit");
        Button deleteButton = new Button("Delete");

        editButton.setOnAction(this::onEditPopup);
        deleteButton.setOnAction(this::onDeletePopup);

        action.getChildren().addAll(editButton, deleteButton);

        return action;
    }

    private void onEditPopup(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/assignment/Admin/EditActivityForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            EditActivityFormController controller = fxmlLoader.getController();
            controller.setActivity(this);

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
            controller.setEntity("./csv_files/add_activities_form.csv", this.id);

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

    public HBox getAction() {
        return action;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
