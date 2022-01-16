module com.example.tron {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.tron to javafx.fxml;
    exports com.example.tron;
}