package com.snake_game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private Button howToPlayButton;

    @FXML
    private Button playButton;

    @FXML
    private Button settingsButton;

    @FXML
    void exitGame(ActionEvent event) {

    }

    @FXML
    void howToPlay(ActionEvent event) {

    }

    @FXML
    void openSettings(ActionEvent event) {

    }

    @FXML
    void playGame(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert exitButton != null : "fx:id=\"exit\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert howToPlayButton != null : "fx:id=\"howToPlay_button\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'menu-view.fxml'.";
        assert settingsButton != null : "fx:id=\"settings\" was not injected: check your FXML file 'menu-view.fxml'.";

    }

}
