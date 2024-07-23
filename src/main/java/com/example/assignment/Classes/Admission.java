package com.example.assignment.Classes;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Arrays;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.updateCSV;

public class Admission {
    private final HBox status;
    private String id;
    private String name;
    private String applicationDate;
    private String email;
    private String faculty;

    public Admission(String id, String name, String email, String applicationDate, String status) {
        this.id = id;
        this.name = name;
        this.applicationDate = applicationDate;
        this.email = email;
        this.status = createHBox(status);
    }

    private HBox createHBox(String defaultStatus) {
        HBox statusActions = new HBox(5);
        ComboBox<String> status = new ComboBox<>();
        Button approveButton = new Button("✓");

        status.getItems().addAll("Pending", "Approved");
        status.setValue(defaultStatus);
        status.setOnAction(e -> {
            approveButton.setDisable(status.getValue().equals("Approved"));
            try {
                updateCSV("./csv_files/add_admission_form.csv",
                        headersMap.get("add_admission_form.csv"), this.id,
                        new String[]{this.id, this.name, this.email, this.applicationDate, status.getValue()}
                );
            } catch (IOException ex) {
                System.out.println(Arrays.toString(ex.getStackTrace()));
            }
        });

        approveButton.setOnAction(e -> {
            approveButton.setDisable(true);
            status.setValue("Approved");
        });


        statusActions.getChildren().addAll(status, approveButton);

        return statusActions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public HBox getStatus() {
        return status;
    }
}
