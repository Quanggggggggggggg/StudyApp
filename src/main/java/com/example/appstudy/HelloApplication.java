package com.example.appstudy;

import com.example.appstudy.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        String fxmlPath = "/com/example/appstudy/MainMenu.fxml";
        URL fxmlUrl = HelloApplication.class.getResource(fxmlPath);
        if (fxmlUrl == null) {
            System.err.println("Lỗi nghiêm trọng: Không thể tìm thấy file FXML tại đường dẫn: " + fxmlPath);
            System.err.println("Vui lòng kiểm tra lại cấu trúc thư mục trong project của bạn.");
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);

        Scene scene = new Scene(fxmlLoader.load(), 900, 700);

        stage.setTitle("IELTS Master");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        SceneManager.getInstance().init(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}

