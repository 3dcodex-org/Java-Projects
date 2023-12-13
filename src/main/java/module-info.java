module com.example.bankmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires bcrypt;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.bankmanagement.bankmanagement;
    opens com.bankmanagement.bankmanagement.model;
    opens com.bankmanagement.bankmanagement.controller to javafx.fxml;
    exports com.bankmanagement.bankmanagement.controller;
    exports com.bankmanagement.bankmanagement.dao.persistentDao;
    exports com.bankmanagement.bankmanagement.model;
    exports com.bankmanagement.bankmanagement.service.serviceClass;
    exports com.bankmanagement.bankmanagement.dao.persistentinit;
    exports com.bankmanagement.bankmanagement;
}