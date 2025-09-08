module com.example.appstudy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.appstudy to javafx.fxml;
    exports com.example.appstudy;
}