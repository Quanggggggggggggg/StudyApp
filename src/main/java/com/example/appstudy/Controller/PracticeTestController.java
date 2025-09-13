package com.example.appstudy.Controller;

import com.example.appstudy.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PracticeTestController {
    public void handleWritingEvaluation(ActionEvent actionEvent) {
    }

    public void handleVocabularyGame(ActionEvent actionEvent) {
    }

    public void handleSpeakingAssessment(ActionEvent actionEvent) {
    }
    private final SceneManager sceneManager = SceneManager.getInstance();
    @FXML
    void goBack(ActionEvent event) {
        sceneManager.goBack();
    }
}
