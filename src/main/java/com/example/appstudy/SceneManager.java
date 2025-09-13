package com.example.appstudy;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class SceneManager {

    private static SceneManager instance;
    private Stage stage;
    private final Stack<Parent> history = new Stack<>();

    private SceneManager() {}

    public static synchronized SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    public void init(Stage stage) {
        this.stage = stage;
    }

    public void switchScene(Object eventSource, String fxmlPath) {
        try {
            Parent currentRoot = ((Node) eventSource).getScene().getRoot();
            history.push(currentRoot); // Lưu lại scene hiện tại vào lịch sử

            Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlPath));
            Scene currentScene = stage.getScene();
            currentScene.setRoot(newRoot);

        } catch (IOException | NullPointerException ex) {
            System.err.println("Lỗi: Không thể tải file FXML: " + fxmlPath);
            ex.printStackTrace();
        }
    }
    public void goBack() {
        if (!history.isEmpty()) {
            Parent previousRoot = history.pop(); // Lấy scene trước đó từ lịch sử
            stage.getScene().setRoot(previousRoot);
        } else {
//            System.out.println("Không có trang nào trong lịch sử. Quay về Main Menu.");
            try {
                // Mặc định quay về Main Menu
                Parent mainMenuRoot = FXMLLoader.load(getClass().getResource("/com/example/appstudy/MainMenu.fxml"));
                stage.getScene().setRoot(mainMenuRoot);
            } catch (IOException e) {
                System.err.println("Lỗi: Không thể tải file FXML của Main Menu.");
                e.printStackTrace();
            }
        }
    }
}

