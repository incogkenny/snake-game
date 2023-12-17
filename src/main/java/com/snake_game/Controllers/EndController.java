package com.snake_game.Controllers;

import com.snake_game.MusicPlayer;
import com.snake_game.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EndController {


    public Play play;
    public Scene menuScene;

    public void setMenuScene(Scene menuScene) {this.menuScene = menuScene;}
    public void setPlay(Play play) {
        this.play = play;
    }
    @FXML
    void playAgain(ActionEvent event) {
        play.reset();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(play.gameScene);
        play.game();
        play.backgroundMusic = new MusicPlayer("src/main/resources/sounds/frogger.mp3",true);
        play.backgroundMusic.start();
    }
    @FXML
    void quit(ActionEvent event) {
        play.reset();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
    }

}
