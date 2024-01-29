module com.example.manou {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    requires com.dlsc.formsfx;

    opens com.example.manou to javafx.fxml;
    exports com.example.manou;
}