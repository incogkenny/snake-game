package com.snake_game.Controllers;

import com.snake_game.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PauseController {
    public Play play;
    public Scene menuScene;

    public void setMenuScene(Scene menuScene) {this.menuScene = menuScene;}
    public void setPlay(Play play) {
        this.play = play;
    }
    @FXML
    void quitGame(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
        play.reset();


    }

    @FXML
    void resumeGame(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(play.gameScene);
        play.timer.start();
    }

}
