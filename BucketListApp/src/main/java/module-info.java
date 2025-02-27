module com.example.booklistapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.goalsApp to javafx.fxml;
    exports com.example.goalsApp;
}