package com.example.appstudy.Controller;

import com.example.appstudy.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class VocabularyController {
    public void searchWord(ActionEvent actionEvent) {
    }

    public void startDailyReview(ActionEvent actionEvent) {
    }

    public void filterWords(ActionEvent actionEvent) {
    }
    private final SceneManager sceneManager = SceneManager.getInstance();
    @FXML
    void goBack(ActionEvent event) {
        sceneManager.goBack();
    }

}
