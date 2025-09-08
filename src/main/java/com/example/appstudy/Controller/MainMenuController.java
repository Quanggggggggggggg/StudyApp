package com.example.appstudy.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainMenuController {

    @FXML private Label avatarLabel;
    @FXML private Label xpLabel;
    @FXML private Label streakLabel;
    @FXML private Label levelLabel;

    @FXML private Button btnLearningPath;
    @FXML private Button btnVocabulary;
    @FXML private Button btnPractice;
    @FXML private Button btnDictionary;
    @FXML private Button btnLeaderboard;
    @FXML private Button btnProfile;
    @FXML private Button settingsBtn;

    @FXML
    private void initialize() {
        avatarLabel.setText("🙂 John Doe");
        xpLabel.setText("XP: 1500");
        streakLabel.setText("🔥 Streak: 7");
        levelLabel.setText("Level: Intermediate");

        btnLearningPath.setOnAction(e -> System.out.println("Go to Learning Path"));
        btnVocabulary.setOnAction(e -> System.out.println("Go to Vocabulary"));
        btnPractice.setOnAction(e -> System.out.println("Go to Practice Test"));
        btnDictionary.setOnAction(e -> System.out.println("Go to Dictionary"));
        btnLeaderboard.setOnAction(e -> System.out.println("Go to Leaderboard"));
        btnProfile.setOnAction(e -> System.out.println("Go to Profile"));
        settingsBtn.setOnAction(e -> System.out.println("Open Settings"));
    }
}
