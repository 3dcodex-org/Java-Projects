package com.bankmanagement.bankmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

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