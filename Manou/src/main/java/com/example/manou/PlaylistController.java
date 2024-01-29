package com.example.manou;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PlaylistController {
    @FXML
    private Label Welcomelabel;

    @FXML
    private ProgressBar progressbar;
    @FXML
    private ButtonBar Searchbar;
    @FXML
    private Slider Volumeslider;

    @FXML
    private Button Searchbutton,Homebutton,Librarybutton,Playlistbutton,Playbutton,Pausebutton,Nextbutton,Previousbutton,Shufflebutton,newplaylistbutton;
    @FXML
    private SplitPane split;
    @FXML
    private Label playlistlabel;



    @FXML
    protected void Searchtrack() {
    }
    @FXML
    protected void toHome() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene;
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("MP3 APPLICATION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void toLibrary() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("library.fxml"));
        Scene scene;
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("MP3 APPLICATION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void toplaylist() {
    }
    @FXML
    protected void Playtrack() {
    }
    @FXML
    protected void Pausetrack() {
    }
    @FXML
    protected void Nexttrack() {
    }
    @FXML
    protected void Previoustrack() {
    }
    @FXML
    protected void Shuffletrack() {
    }
    @FXML
    protected void createplaylist() {
    }
}
