package com.bankmanagement.bankmanagement;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.bankmanagement.bankmanagement.dao.persistentDao.AccountDao;
import com.bankmanagement.bankmanagement.dao.persistentDao.EmployeeDao;
import com.bankmanagement.bankmanagement.model.Account;
import com.bankmanagement.bankmanagement.model.Employee;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
//        Employee employee = new Employee();
//        employee.setUsername("emmanuel");
//        String password = "password";
//        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
//        employee.setPassword(bcryptHashString);

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 779, 604);
        stage.setTitle("Bank Management System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("image/ictu-logo.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}