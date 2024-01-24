module com.ecommerceapp.ecommerceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;

    opens com.ecommerceapp.ecommerceapp to javafx.fxml;
    exports com.ecommerceapp.ecommerceapp;
}