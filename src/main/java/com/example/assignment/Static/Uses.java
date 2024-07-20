package com.example.assignment.Static;

import com.example.assignment.HelloApplication;
import com.example.assignment.MainPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Uses {

    // Stages methods
    public static Stage getCurrentStage(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        return stage;
    }

    public static void changeScene(ActionEvent event, String sceneName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((HelloApplication.class.getResource(sceneName)));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = getCurrentStage(event);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void createPopup(ActionEvent event, String sceneName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((MainPage.class.getResource(sceneName)));
//        Maybe there's another way to implement this.
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        popupStage.setScene(new Scene(fxmlLoader.load()));
        popupStage.setResizable(false);

//        TODO: refresh the source stage
        popupStage.setOnHidden(e -> {
            Stage sourceStage = getCurrentStage(event);
        });
        popupStage.showAndWait();
    }

}