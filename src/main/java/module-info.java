module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
//    requires org.junit.jupiter.api;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}