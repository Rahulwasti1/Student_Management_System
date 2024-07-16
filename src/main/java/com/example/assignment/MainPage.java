package com.example.assignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.assignment.Uses.writeCSV;

public class MainPage extends Application {
    public static void main(String[] args) {
        initializeFiles();
        launch();
    }

    public static void initializeFiles() {
        final String DIRECTORY_NAME = "csv_files";
//       List of Map of <"filepath": {"column1", "column2", "column3",...}>
        List<Map.Entry<String, String[]>> fileHeaders = new ArrayList<>();

        fileHeaders.add(new AbstractMap.SimpleEntry<>("add_student_form.csv", new String[]{
                "student_id", "first_name", "last_name", "gender", "ph_number", "email", "faculty"
        }));
//        TODO: add more manually :(

        try {
//            get directory path
            Path directoryPath = Paths.get(DIRECTORY_NAME);

//            if directory doesn't exist, create one
            if (!Files.exists(directoryPath)) {
                System.out.println("Creating directory...");
                Files.createDirectory(directoryPath);
            }

            for (Map.Entry<String, String[]> fileHeader : fileHeaders) {
                Path filePath = Paths.get(DIRECTORY_NAME, fileHeader.getKey());
                String[] headers = fileHeader.getValue();
//            if file doesn't exist, create one
                if (!Files.exists(filePath)) {
                    writeCSV(filePath.toString(), headers, new String[]{});
                    System.out.printf("Created %s with headers successfully.\n", filePath);
                } else {
                    System.out.printf("File %s already exists. Skipping.\n", filePath);
                }
            }
        } catch (IOException e) {
            System.out.println("Error initializing CSV files.");
            System.out.println(e.getMessage());
        }
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