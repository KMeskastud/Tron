module com.example.tron {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.junit.jupiter.api;


    opens com.example.tron to javafx.fxml;
    exports com.example.tron;
}