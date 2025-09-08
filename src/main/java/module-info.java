module com.example.appstudy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.appstudy to javafx.fxml;
    opens com.example.appstudy.Controller to javafx.fxml; // 👈 thêm dòng này

    exports com.example.appstudy;
    exports com.example.appstudy.Controller; // 👈 optional, chỉ cần nếu bạn muốn dùng controller ở module khác
}
