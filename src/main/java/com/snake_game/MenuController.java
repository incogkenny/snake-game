package com.snake_game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MenuController {


    @FXML
    private Button exitButton;

    @FXML
    private Button howToPlayButton;

    @FXML
    private Button playButton;

    @FXML
    private Button settingsButton;

    private Scene settingsScene;
    private Scene howToPlayScene;

    // sets
    public void setSettingsScene(Scene scene){
        settingsScene = scene;
    }
    public void setHowToPlayScene(Scene scene) {
        howToPlayScene = scene;
    }


    @FXML
    void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void howToPlay(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(howToPlayScene);
    }

    @FXML
    void openSettings(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(settingsScene);
    }

    @FXML
    void playGame() {
        Play.main(null);
        Platform.exit();
    }

    @FXML
    void initialize() {
        assert exitButton != null : "fx:id=\"exit\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert howToPlayButton != null : "fx:id=\"howToPlay_button\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert settingsButton != null : "fx:id=\"settings\" was not injected: check your FXML file 'menu-view.fxml'.";

    }


}
