package com.example.assignment.Staff;

import com.example.assignment.Classes.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.readCSV;
import static com.example.assignment.Static.Uses.changeScene;
import static com.example.assignment.Static.Uses.createPopup;

public class ManageLibraryController implements Initializable {
    @FXML
    TableView<Book> manageLibraryTable;

    @FXML
    TableColumn<Book, String> bookId, studentName, bookName, bookNumber, bookStatus;

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "Student Management System - Login");
    }

    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Staff/Dashboard.fxml", "Staff Dashboard");
    }

    @FXML
    public void clickManageAdmissions(ActionEvent event) throws IOException {
        changeScene(event, "Staff/ManageAdmissions.fxml", "Staff - Manage Admissions");
    }

    @FXML
    public void onAddDetails(ActionEvent event) throws IOException {
        createPopup(event, "Staff/AddNewDetails.fxml", "Staff - Add New Book Details");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookName.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        bookNumber.setCellValueFactory(new PropertyValueFactory<>("bookNumber"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        bookStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        try {
            List<Book> data = readCSV("./csv_files/add_details.csv", headersMap.get("add_details.csv"), Book.class);
            for (Book book : data) {
                manageLibraryTable.getItems().add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
