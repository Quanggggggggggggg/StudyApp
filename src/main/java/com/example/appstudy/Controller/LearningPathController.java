package com.example.appstudy.Controller;

import com.example.appstudy.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class LearningPathController {

    // Khai báo các VBox chứa nội dung chi tiết
    @FXML private VBox lesson1Details;
    @FXML private VBox lesson2Details;
    @FXML private VBox lesson3Details;
    @FXML private VBox lesson4Details;
    @FXML private VBox lesson5Details;
    @FXML private VBox lesson6Details;
    @FXML private VBox lesson7Details;
    @FXML private VBox lesson8Details;
    @FXML private VBox lesson9Details;
    @FXML private VBox lesson10Details;

    // Khai báo các VBox CHA chứa cả Button và nội dung chi tiết
    @FXML private VBox lesson1Container;
    @FXML private VBox lesson2Container;
    @FXML private VBox lesson3Container;
    @FXML private VBox lesson4Container;
    @FXML private VBox lesson5Container;
    @FXML private VBox lesson6Container;
    @FXML private VBox lesson7Container;
    @FXML private VBox lesson8Container;
    @FXML private VBox lesson9Container;
    @FXML private VBox lesson10Container;

    // Map để quản lý VBox chi tiết
    private final Map<String, VBox> lessonDetailsMap = new HashMap<>();
    // Map để quản lý VBox cha (container)
    private final Map<String, VBox> lessonContainersMap = new HashMap<>();

    // Biến để theo dõi lesson nào đang được mở, null nghĩa là không có cái nào
    private String activeLessonId = null;

    @FXML
    public void initialize() {
        // Ánh xạ ID với VBox chi tiết
        lessonDetailsMap.put("1", lesson1Details);
        lessonDetailsMap.put("2", lesson2Details);
        lessonDetailsMap.put("3", lesson3Details);
        lessonDetailsMap.put("4", lesson4Details);
        lessonDetailsMap.put("5", lesson5Details);
        lessonDetailsMap.put("6", lesson6Details);
        lessonDetailsMap.put("7", lesson7Details);
        lessonDetailsMap.put("8", lesson8Details);
        lessonDetailsMap.put("9", lesson9Details);
        lessonDetailsMap.put("10", lesson10Details);

        // Ánh xạ ID với VBox cha
        lessonContainersMap.put("1", lesson1Container);
        lessonContainersMap.put("2", lesson2Container);
        lessonContainersMap.put("3", lesson3Container);
        lessonContainersMap.put("4", lesson4Container);
        lessonContainersMap.put("5", lesson5Container);
        lessonContainersMap.put("6", lesson6Container);
        lessonContainersMap.put("7", lesson7Container);
        lessonContainersMap.put("8", lesson8Container);
        lessonContainersMap.put("9", lesson9Container);
        lessonContainersMap.put("10", lesson10Container);
    }

    @FXML
    private void handleToggle(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String clickedId = (String) clickedButton.getUserData();

        // TRƯỜNG HỢP 1: Nhấn vào chính lesson đang mở để đóng lại và quay về danh sách
        if (clickedId.equals(activeLessonId)) {
            // Hiện lại tất cả các lesson container
            for (VBox container : lessonContainersMap.values()) {
                container.setVisible(true);
                container.setManaged(true);
            }
            // Ẩn VBox chi tiết đang mở
            VBox detailsToHide = lessonDetailsMap.get(clickedId);
            if (detailsToHide != null) {
                detailsToHide.setVisible(false);
                detailsToHide.setManaged(false);
            }
            // Đặt lại trạng thái, không có lesson nào đang active
            activeLessonId = null;
        }
        // TRƯỜNG HỢP 2: Nhấn vào một lesson mới để xem chi tiết
        else {
            // Ẩn tất cả các lesson container
            for (VBox container : lessonContainersMap.values()) {
                container.setVisible(false);
                container.setManaged(false);
            }

            // Chỉ hiện container của lesson được chọn
            VBox containerToShow = lessonContainersMap.get(clickedId);
            if (containerToShow != null) {
                containerToShow.setVisible(true);
                containerToShow.setManaged(true);
            }

            // Và hiện nội dung chi tiết của nó
            VBox detailsToShow = lessonDetailsMap.get(clickedId);
            if (detailsToShow != null) {
                detailsToShow.setVisible(true);
                detailsToShow.setManaged(true);
            }

            // Cập nhật lesson đang active
            activeLessonId = clickedId;
        }
    }
    private final SceneManager sceneManager = SceneManager.getInstance();
    @FXML
    void goBack(ActionEvent event) {
        sceneManager.goBack();
    }
}