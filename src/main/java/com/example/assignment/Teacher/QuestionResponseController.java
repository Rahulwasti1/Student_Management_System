package com.example.assignment.Teacher;

import com.example.assignment.Classes.Question;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.updateCSV;

public class QuestionResponseController {
    @FXML
    TextField questionText;

    @FXML
    TextArea message;

    @FXML
    Button sendButton;

    private Question question;

    public void setQuestion(Question question) {
        this.question = question;
        questionText.setDisable(true);
        questionText.setText(question.getQuestion());
    }

    @FXML
    public void onSend() throws IOException {
        String[] data = new String[]{this.question.getId(), this.question.getPosition(), this.question.getQuestion(), "Resolved"};
        boolean recordUpdated = updateCSV("./csv_files/add_question_form.csv", headersMap.get("add_question_form.csv"), this.question.getId(), data);
        ((Stage) sendButton.getScene().getWindow()).close();
    }
}
