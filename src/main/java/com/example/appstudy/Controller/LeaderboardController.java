package com.example.appstudy.Controller;

import com.example.appstudy.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LeaderboardController {
    private final SceneManager sceneManager = SceneManager.getInstance();
    @FXML
    void goBack(ActionEvent event) {
        sceneManager.goBack();
    }
}
