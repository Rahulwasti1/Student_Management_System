package com.example.assignment.Classes;

import com.example.assignment.Admin.EditTeacherFormController;
import com.example.assignment.DeleteConfirmationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Teacher extends User {
    private final HBox action;
    private String name;
    private String number;
    private String subject;

    public Teacher(String id, String name, String gender, String number, String email, String password) {
        this.setId(id);
        this.name = name;
        this.setGender(gender);
        this.number = number;
        this.setEmail(email);
        this.setPassword(password);
        setSubject("None");

        this.action = createActionButtons();
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/assignment/Admin/EditTeacherForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            EditTeacherFormController controller = fxmlLoader.getController();
            controller.setTeacher(this);

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
            controller.setEntity("./csv_files/add_teacher_form.csv", this.getId());

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public HBox getAction() {
        return action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
