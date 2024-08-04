package com.example.assignment.Teacher;

import com.example.assignment.Classes.Grade;
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

public class GradeManagementController implements Initializable {
    @FXML
    TableView<Grade> gradesTable;

    @FXML
    TableColumn<Grade, String> gradeId, studentName, studentGender, gradePercentage, studentEmail, gradeAction;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gradeId.setCellValueFactory(new PropertyValueFactory<>("id"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        gradePercentage.setCellValueFactory(new PropertyValueFactory<>("percentage"));
        studentEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        try {
            List<Grade> data = readCSV("./csv_files/add_grade_form.csv", headersMap.get("add_grade_form"), Grade.class);
            for (Grade grade : data) {
                gradesTable.getItems().add(grade);
            }

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.getCause();
        }
    }

    @FXML
    public void clickTeacherDashboard(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/Dashboard.fxml", "Teacher - Dashboard");
    }

    @FXML
    public void clickTeacherViewGrades(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/GradeManagement.fxml", "Teacher - Manage Grades");
    }

    @FXML
    public void clickTeacherViewQuestionForm(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/ViewQuestionForm.fxml", "Teacher - Question Form ");
    }

    @FXML
    public void clickTeacherProblemForm(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/ProblemForm.fxml", "Teacher - Problems");
    }

    @FXML
    public void clickTeacherCreateMCQ(ActionEvent event) throws IOException {
        changeScene(event, "Teacher/CreateMCQ.fxml", "Teacher - Create MCQ");
    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "Login.fxml", "LOGIN");

    }

    @FXML
    public void onAddNewGrade(ActionEvent event) throws IOException {
        createPopup(event, "Teacher/AddNewGrade.fxml", "Teacher - Add New Grade Form");
    }
}
