package com.snake_game.Controllers;

import com.snake_game.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class PauseController {
    public Play play;
    public Scene menuScene;

    public void setMenuScene(Scene menuScene) {this.menuScene = menuScene;}
    public void setPlay(Play play) {
        this.play = play;
    }
    @FXML
    void quitGame() {

    }

    @FXML
    void resumeGame() {

    }

}
