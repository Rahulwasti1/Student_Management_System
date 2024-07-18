package com.example.assignment;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Uses {
    public static final Map<String, String[]> headersMap = new HashMap<>();

    static {
        headersMap.put("add_student_form.csv", new String[]{
                "student_id", "first_name", "last_name", "gender", "ph_number", "email", "faculty"
        });
        headersMap.put("add_teacher_form.csv", new String[]{
                "teacher_id", "name", "gender", "ph_number", "email", "password"
        });
        headersMap.put("add_staff_form.csv", new String[]{
                "staff_id", "name", "gender", "ph_number", "email", "password"
        });
        headersMap.put("add_activities_form.csv", new String[]{
                "activity_id", "activity_type", "activity_date"
        });
    }

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
     * Creates directories and files if they do not exist.
     */
    public static void initializeFiles() {
        final String DIRECTORY_NAME = "csv_files";
        try {
            Path directoryPath = Paths.get(DIRECTORY_NAME);

//            if directory doesn't exist, create one
            if (!Files.exists(directoryPath)) {
                System.out.println("Creating directory...");
                Files.createDirectory(directoryPath);
            }

            headersMap.forEach((key, value) -> {
                Path filePath = Paths.get(DIRECTORY_NAME, key);
//            if file doesn't exist, create one
                if (!Files.exists(filePath)) {
                    try {
                        writeCSV(filePath.toString(), value, new String[]{});
                    } catch (IOException e) {
                        System.out.printf("Failed to write to file %s\n.", filePath);
                    }
                    System.out.printf("Created %s with headers successfully.\n", filePath);
                } else {
                    System.out.printf("File %s already exists. Skipping.\n", filePath);
                }
            });

        } catch (IOException e) {
            System.out.println("Error initializing CSV files.");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a new CSV file and writes to it.
     *
     * @param filename path of the CSV file
     * @param headers  headers (column names) for the CSV file
     * @param data     records for the CSV file
     * @return boolean {@code true} if file is written successfully {@code false} otherwise
     * @throws IOException when filename not found
     */
    public static boolean writeCSV(String filename, String[] headers, List<String[]> data) {
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
     * @return {@code boolean} {@code true} if file is written successfully {@code false} otherwise
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
     */
    public static boolean appendCSV(String filename, List<String[]> data) {
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
     */
    public static boolean appendCSV(String filename, String[] record) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true))) {
            writer.writeNext(record);

            return true;
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            return false;
        }
    }

    /**
     * Reads a CSV file and returns the content as a 2D array of strings.
     *
     * @param filename path of the CSV file
     * @param headers  headers (column names) for the CSV file
     * @return {@code String[][]} a 2D array of strings containing CSV data
     */
    public static List<String[]> readCSV(String filename, String[] headers) throws IOException {
        ArrayList<String[]> records = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filename))) {
            String[] nextLine;
            // exhaust the first line for headers
            if ((nextLine = reader.readNext()) != null) {
                if (!java.util.Arrays.equals(nextLine, headers)) {
                    throw new IOException("CSV headers do not match the provided headers.");
                }
            }

            while ((nextLine = reader.readNext()) != null) {
                records.add(nextLine);
            }
        } catch (IOException | CsvValidationException exc) {
            System.out.println(exc.getMessage());
        }

        return records;
    }
}