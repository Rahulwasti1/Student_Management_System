package com.example.assignment;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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

    public static void createPopup(String sceneName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((MainPage.class.getResource(sceneName)));
//        Maybe there's another way to implement this.
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        popupStage.setScene(new Scene(fxmlLoader.load()));
        popupStage.setResizable(false);
        popupStage.showAndWait();
    }

    // CSV Methods (requires opencsv)

    /**
     * Creates a new CSV file and writes to it.
     *
     * @param filename path of the CSV file
     * @param headers  headers (column names) for the CSV file
     * @param data     records for the CSV file
     * @return boolean {@code true} if file is written successfully {@code false} otherwise
     * @throws IOException when filename not found
     */
    public static boolean writeCSV(String filename, String[] headers, List<String[]> data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            writer.writeNext(headers);

            for (String[] record : data) {
                writer.writeNext(record);
            }

            return true;
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            return false;
        }
    }


    /**
     * Creates a new CSV file and writes to it.
     *
     * @param filename path of the CSV file
     * @param headers  headers (column names) for the CSV file
     * @param record   a single records for the CSV file
     * @return boolean {@code true} if file is written successfully {@code false} otherwise
     * @throws IOException when filename not found
     */
    public static boolean writeCSV(String filename, String[] headers, String[] record) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
            writer.writeNext(headers);
            writer.writeNext(record);

            return true;
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            return false;
        }
    }

    /**
     * Appends a list of records to an existing CSV file.
     *
     * @param filename path of the CSV file
     * @param data     records for the CSV file
     * @return boolean {@code true} if file is written successfully {@code false} otherwise
     * @throws IOException when filename not found
     */
    public static boolean appendCSV(String filename, List<String[]> data) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true))) {
            for (String[] record : data) {
                writer.writeNext(record);
            }

            return true;
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            return false;
        }
    }


    /**
     * Appends a single record to an existing CSV file.
     *
     * @param filename path of the CSV file
     * @param record   a single record for the CSV file
     * @return boolean {@code true} if file is written successfully {@code false} otherwise
     * @throws IOException when filename not found
     */
    public static boolean appendCSV(String filename, String[] record) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true))) {
            writer.writeNext(record);

            return true;
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            return false;
        }
    }
}