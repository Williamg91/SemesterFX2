module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fazecast.jSerialComm;
    requires java.sql;

    opens org.example to javafx.fxml;
    exports org.example.ViewsAndControllers to javafx.fxml;
    opens org.example.ViewsAndControllers to javafx.fxml;
    exports org.example;
}