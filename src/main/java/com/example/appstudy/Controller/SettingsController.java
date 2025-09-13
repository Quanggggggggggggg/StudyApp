package com.example.appstudy.Controller;

import com.example.appstudy.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SettingsController {

    private final SceneManager sceneManager = SceneManager.getInstance();
    @FXML
    void goBack(ActionEvent event) {
        sceneManager.goBack();
    }
    @FXML
    public void saveSettings(ActionEvent actionEvent) {
        System.out.println("Settings saved!");
    }
    @FXML
    public void handleLogout(ActionEvent actionEvent) {
        System.out.println("User logged out!");
    }
}

