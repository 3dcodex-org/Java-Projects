package com.example.manou;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class LibraryController implements Initializable {

    @FXML
    private Label Welcomelabel;
    @FXML
    private Label musiclabel;
    @FXML
    private Label songLabel;
    @FXML
    private ProgressBar progressbar;
    @FXML
    private ButtonBar Searchbar;
    @FXML
    private Slider Volumeslider;

    @FXML
    private SplitPane split;
    @FXML
    private Button Searchbutton,Homebutton,Librarybutton,Playlistbutton,Playbutton,Pausebutton,Nextbutton,
            Previousbutton,shuffleandplaybutton,sortbutton,resetbutton;

    @FXML
    private ListView musiclist;

    private Media media;
    private MediaPlayer mediaPlayer;
    private File directory;
    private File []files;
    private ArrayList<File> songs;

    private int songNumber;
    private Timer timer;
    private boolean running;



    public void initialize(){
        Media media= new Media("C://Users//hp//IdeaProjects//Manou//src//main//java//com//example//manou//music");
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        progressbar=new ProgressBar();
        progressbar.setProgress(0);
        beginTimer();
    }
    public void beginTimer(){
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds(); // problem here
                double end = media.getDuration().toSeconds();

                progressbar.setProgress(current / end);

                if (current / end == 1) {
                    cancelTimer();
                }


            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);



    }

    public void cancelTimer(){
        //running=false;
        //timer.cancel();
        // added this
        if (timer != null) {
            timer.cancel();
        }
        running=false;


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        songs = new ArrayList<File>();
        directory = new File("C://Users//hp//IdeaProjects//Manou//src//main//java//com//example//manou//music");
        files= directory.listFiles();

        if(files != null){
            for (File file : files){
                songs.add(file);
                System.out.println(file);
            }
        }

        if (songNumber>= 0 && songNumber < songs.size()){
            media= new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer= new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
            mediaPlayer.play(); //added this

        }
        else{
            System.out.println("invalid song number:" + songNumber);
        }

        Volumeslider.valueProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number t1) {
                mediaPlayer.setVolume(Volumeslider.getValue()* 0.01); //problem here

            }
        });
        progressbar.setStyle("-fx-accent: #006666;");

    }



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
    protected void toLibrary() {
    }
    @FXML
    protected void toplaylist() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlist.fxml"));
        Scene scene;
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("MP3 APPLICATION");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void Playtrack() {
        beginTimer();
        mediaPlayer.setVolume(Volumeslider.getValue()* 0.01);
        mediaPlayer.play();
    }
    @FXML
    protected void Pausetrack() {

            cancelTimer();
            mediaPlayer.pause();
    }
    @FXML
    protected void Nexttrack() {
        //checks current song number and moves to the next song
        if (songNumber < songs.size() - 1) {
            songNumber++;
            mediaPlayer.stop();
            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());  //added Media
            mediaPlayer = new MediaPlayer(media);


            songLabel.setText(songs.get(songNumber).getName());
            Playtrack();
        }
        // enables the song to start back after the last song is played.
        else {
            songNumber = 0;
            mediaPlayer.stop();
            if (running) {
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            songLabel.setText(songs.get(songNumber).getName());
            Playtrack();
        }
    }
    @FXML
    protected void Previoustrack() {
        //moves to previous song
        if (songNumber >0) {
            songNumber--;
            mediaPlayer.stop();
            if (running){
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer= new MediaPlayer(media);

            songLabel.setText(songs.get(songNumber).getName());
            Playtrack();
        }
        // enables the last song to be played if the 'previous' button is clicked when the first song is playing.
        else{
            songNumber = songs.size() -1;
            mediaPlayer.stop();
            if (running){
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer= new MediaPlayer(media);

            songLabel.setText(songs.get(songNumber).getName());
            Playtrack();
        }


    }
    @FXML
    protected void resettrack() {
        progressbar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0));
    }
    @FXML
    protected void shuffleandplay() {
        ArrayList<Integer> shuffledIndices = new ArrayList<>();
        while (shuffledIndices.size() < songs.size()) {
            int randomIndex = (int) (Math.random() * songs.size());
            if (!shuffledIndices.contains(randomIndex)) {
                shuffledIndices.add(randomIndex);
            }
        }
        ArrayList<File> shuffledSongs = new ArrayList<>();
        for (int index : shuffledIndices) {
            shuffledSongs.add(songs.get(index));
        }
        // Play the first song in the shuffled ArrayList
        media = new Media(shuffledSongs.get(0).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        songLabel.setText(shuffledSongs.get(0).getName());
        mediaPlayer.play();
        cancelTimer();
        mediaPlayer.pause();
    }
    @FXML
    protected void sorttrack() {
    }


}
