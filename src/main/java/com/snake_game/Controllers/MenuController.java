package com.snake_game.Controllers;

import com.snake_game.MusicPlayer;
import com.snake_game.Play;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MenuController {

    @FXML
    private TextField username;
    @FXML
    private Button playButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button exitButton;
    @FXML
    private Label namePrompt;
    private Scene settingsScene;
    private Scene leaderboardScene;
    public Play play;


    public void setPlay(Play play) {
        this.play = play;
    }
    // sets
    public void setSettingsScene(Scene scene){
        settingsScene = scene;
    }
    public void setLeaderboardScene(Scene scene) {leaderboardScene = scene;}
    @FXML
    void playGame(ActionEvent event) {
        if (username.getText().trim().isEmpty()){
            namePrompt.setVisible(true);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), namePrompt);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.setCycleCount(Animation.INDEFINITE);
            fadeTransition.play();
        }
        else{
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(play.getGameScene());
            play.game();
            MusicPlayer.getMusicPlay("src/main/resources/sounds/frogger.mp3");
        }

    }
    @FXML
    void openSettings(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(settingsScene);
    }

    @FXML
    void leaderboard(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(leaderboardScene);
    }
    @FXML
    void exitGame() {
        Platform.exit();
        System.exit(0);
    }





    @FXML
    void initialize() {
        assert exitButton != null : "fx:id=\"exit\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert settingsButton != null : "fx:id=\"settings\" was not injected: check your FXML file 'menu-view.fxml'.";

    }



}
