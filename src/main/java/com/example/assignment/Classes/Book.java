package com.example.assignment.Classes;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Arrays;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.updateCSV;

public class Book {
    private final HBox status;
    private String studentId;
    private String studentName;
    private String bookId;
    private String bookName;
    private String bookNumber;

    public Book(String studentId, String studentName, String bookName, String bookNumber, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.bookName = bookName;
        this.bookNumber = bookNumber;
        this.status = createHBox(status);
    }

    private HBox createHBox(String defaultStatus) {
        HBox statusView = new HBox(5);
        ComboBox<String> status = new ComboBox<>();
        Button switchStatusButton = new Button("...");

        status.getItems().addAll("Pending", "Returned");
        status.setValue(defaultStatus);
        status.setOnAction(e -> {
            try {
                updateCSV("./csv_files/add_details.csv", headersMap.get("add_details.csv"),
                        this.studentId,
                        new String[]{this.studentId, this.studentName, this.bookName, this.bookNumber, status.getValue()}
                );
            } catch (IOException exc) {
                System.out.println(Arrays.toString(exc.getStackTrace()));
            }
        });
        switchStatusButton.setOnAction(e -> status.setValue(status.getValue().equals("Pending") ? "Returned" : "Pending"));


        statusView.getChildren().addAll(status, switchStatusButton);

        return statusView;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public HBox getStatus() {
        return status;
    }
}
