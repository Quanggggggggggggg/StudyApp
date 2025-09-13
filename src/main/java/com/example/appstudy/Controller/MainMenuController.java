package com.example.appstudy.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    // === KHAI BÁO BIẾN CHO CÁC THÀNH PHẦN GIAO DIỆN ===
    @FXML private Label lblUsername;
    @FXML private Label levelLabel;
    @FXML private Label avatarLabel;
    @FXML private Label lblLastLesson;
    @FXML private Button btnContinueLearning;
    @FXML private Label xpLabel;
    @FXML private Label streakLabel;

    // Nút Settings đã được khai báo ở đây
    @FXML private Button settingsBtn;

    // Các thẻ chức năng
    @FXML private VBox cardLearningPath;
    @FXML private VBox cardVocabulary;
    @FXML private VBox cardPractice;
    @FXML private VBox cardDictionary;
    @FXML private VBox cardLeaderboard;
    @FXML private VBox cardProfile;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // 1. Set User Data (Dữ liệu mẫu)
        lblUsername.setText("Quang VU");
        avatarLabel.setText("QV");
        xpLabel.setText("15,450");
        streakLabel.setText("12 Days");
        levelLabel.setText("Intermediate Level");
        lblLastLesson.setText("Lesson 3: Listening Deep Dive");

        // 2. Gán sự kiện cho các thẻ VBox
        cardLearningPath.setOnMouseClicked(event -> switchScene(event, "/com/example/appstudy/views/learning-path.fxml"));
        cardVocabulary.setOnMouseClicked(event -> switchScene(event, "/com/example/appstudy/views/vocabulary.fxml"));
        cardPractice.setOnMouseClicked(event -> switchScene(event, "/com/example/appstudy/views/practice-test.fxml"));
        cardDictionary.setOnMouseClicked(event -> switchScene(event, "/com/example/appstudy/views/dictionary.fxml"));
        cardLeaderboard.setOnMouseClicked(event -> switchScene(event, "/com/example/appstudy/views/leaderboard.fxml"));
        cardProfile.setOnMouseClicked(event -> switchScene(event, "/com/example/appstudy/views/profile.fxml"));

        // 3. Gán sự kiện cho các Button
        btnContinueLearning.setOnAction(event -> {
            System.out.println("Continue Learning button clicked!");
        });

        // =================================================================
        // PHẦN QUAN TRỌNG NHẤT: GÁN LẠI SỰ KIỆN CHO NÚT SETTINGS
        // Dòng code này đảm bảo khi nút settingsBtn được nhấn, nó sẽ gọi hàm switchScene
        // =================================================================
        if (settingsBtn != null) {
            settingsBtn.setOnAction(e -> switchScene(e, "/com/example/appstudy/views/settings.fxml"));
        }
    }

    /**
     * Phương thức chuyển Scene cho các sự kiện click chuột (MouseEvent).
     */
    private void switchScene(MouseEvent event, String fxmlPath) {
        loadScene(event.getSource(), fxmlPath);
    }

    /**
     * Phương thức chuyển Scene cho các sự kiện từ Button (ActionEvent).
     */
    private void switchScene(ActionEvent event, String fxmlPath) {
        loadScene(event.getSource(), fxmlPath);
    }

    /**
     * Helper method để tải và hiển thị một scene mới, tránh lặp code.
     */
    private void loadScene(Object eventSource, String fxmlPath) {
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) ((Node) eventSource).getScene().getWindow();
            Scene currentScene = stage.getScene();
            stage.setScene(new Scene(newRoot, currentScene.getWidth(), currentScene.getHeight()));
            stage.show();
        } catch (IOException | NullPointerException ex) {
            System.err.println("Lỗi: Không thể tải file FXML: " + fxmlPath);
            ex.printStackTrace();
        }
    }
}

