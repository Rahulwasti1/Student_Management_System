package com.example.assignment.Static;

import com.example.assignment.Classes.Staff;
import com.example.assignment.Classes.Student;
import com.example.assignment.Classes.Teacher;
import com.example.assignment.HelloApplication;
import com.example.assignment.MainPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.function.Consumer;

import static com.example.assignment.Static.CSVUtils.headersMap;
import static com.example.assignment.Static.CSVUtils.readCSV;

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

    public static void createPopup(ActionEvent event, String sceneName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((MainPage.class.getResource(sceneName)));
//        Maybe there's another way to implement this.
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        popupStage.setScene(new Scene(fxmlLoader.load()));
        popupStage.setResizable(false);

//        TODO: refresh the source stage
        popupStage.setOnHidden(e -> {
            Stage sourceStage = getCurrentStage(event);
            sourceStage.setScene(sourceStage.getScene());
        });
        popupStage.showAndWait();
    }

    public static void createPopup(ActionEvent event, String sceneName, String title, Consumer<Object> controllerConsumer) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((MainPage.class.getResource(sceneName)));

        fxmlLoader.setControllerFactory(controllerClass -> {
            try {
                Object controller = controllerClass.getDeclaredConstructor().newInstance();
                controllerConsumer.accept(controller);
                return controller;
            } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                     NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        });


        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        popupStage.setScene(new Scene(fxmlLoader.load()));
        popupStage.setResizable(false);

        popupStage.showAndWait();
    }

    /**
     * @param email      email to validate
     * @param password   password to validate
     * @param filename   file to look through
     * @param headersKey the headers (required to read CSV)
     * @param clazz      account type (class) to read CSV
     * @param <T>        Account Type (Student, Teacher, Staff, Admin)
     * @return boolean
     */
    public static <T> boolean validateLogin(String email, String password, String filename, String headersKey, Class<T> clazz) {
        try {
            List<T> data = readCSV(filename, headersMap.get(headersKey), clazz);
            for (T record : data) {
                if (record instanceof Student student) {
                    if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                        return true;
                    }
                }
                if (record instanceof Teacher teacher) {
                    if (teacher.getEmail().equals(email) && teacher.getPassword().equals(password)) {
                        return true;
                    }
                }
                if (record instanceof Staff staff) {
                    if (staff.getEmail().equals(email) && staff.getPassword().equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            e.getCause();
        }
        return false;
    }
}