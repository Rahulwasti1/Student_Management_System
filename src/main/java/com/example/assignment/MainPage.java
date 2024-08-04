package com.example.assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.assignment.Static.CSVUtils.initializeFiles;

public class MainPage extends Application {
    public static void main(String[] args) {
        initializeFiles();
        launch();
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("LOGIN PAGE");
        stage.setScene(scene);
        stage.show();
    }
}