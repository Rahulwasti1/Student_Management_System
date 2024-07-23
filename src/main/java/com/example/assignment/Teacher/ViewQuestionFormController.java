package com.example.assignment.Teacher;

import com.example.assignment.Classes.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.readCSV;
import static com.example.assignment.Static.Uses.changeScene;

public class ViewQuestionFormController implements Initializable {
    @FXML
    TableView<Question> questionTable;

    @FXML
    TableColumn<Question, String> questionId, questionCreator, questionText;

    @FXML
    TableColumn<Question, HBox> questionStatus;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        questionId.setCellValueFactory(new PropertyValueFactory<>("id"));
        questionCreator.setCellValueFactory(new PropertyValueFactory<>("creator"));
        questionText.setCellValueFactory(new PropertyValueFactory<>("question"));
        questionStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        try {
            List<Question> data = readCSV("./csv_files/add_question_form.csv", headersMap.get("add_question_form.csv"), Question.class);

            for (Question qn : data) {
                questionTable.getItems().add(qn);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
