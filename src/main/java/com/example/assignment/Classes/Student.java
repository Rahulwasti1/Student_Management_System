package com.example.assignment.Classes;

import com.example.assignment.Admin.EditStudentFormController;
import com.example.assignment.DeleteConfirmationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Student extends User {
    private final HBox action;
    private String fullName;
    private String gender;
    private String phoneNumber;
    private String faculty;

    public Student(String id, String firstName, String lastName, String gender, String phoneNumber, String email, String faculty, String password) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.fullName = firstName + " " + lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.setEmail(email);
        this.faculty = faculty;
        this.setPassword(password);

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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/assignment/Admin/EditStudentForm.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            EditStudentFormController controller = fxmlLoader.getController();
            controller.setStudent(this);

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
            controller.setEntity("./csv_files/add_student_form.csv", this.getId());

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


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
