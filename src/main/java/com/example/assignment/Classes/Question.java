package com.example.assignment.Classes;

import com.example.assignment.Teacher.QuestionResponseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Question {
    private final HBox status;
    private String id;
    private String creator;
    private String question;
    private String position;

    public Question(String id, String position, String question, String status) {
        this.id = id;
        this.position = position;
        this.creator = "Unknown";
        this.question = question;
        this.status = createHBox();
    }

    public HBox createHBox() {
        HBox status = new HBox(5);
        ComboBox<String> statusCombo = new ComboBox<>();
        Button action = new Button("✓");

        statusCombo.getItems().addAll("Pending", "Resolved");
        statusCombo.setValue("Pending");

        statusCombo.setOnAction(e -> {
            action.setDisable(statusCombo.getValue().equals("Resolved"));
        });

        action.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/assignment/Teacher/QuestionResponse.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                QuestionResponseController controller = fxmlLoader.getController();
                controller.setQuestion(this);

                Stage popupStage = new Stage();
                popupStage.initModality(Modality.APPLICATION_MODAL);
                popupStage.setTitle("Edit Activity");
                popupStage.setScene(scene);
                popupStage.setResizable(false);
                popupStage.showAndWait();

                statusCombo.setValue("Resolved");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println(ex.getStackTrace());
            }
        });

        status.getChildren().addAll(statusCombo, action);
        return status;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public HBox getStatus() {
        return status;
    }
}
