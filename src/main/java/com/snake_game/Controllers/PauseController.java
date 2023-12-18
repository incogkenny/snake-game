package com.snake_game.Controllers;

import com.snake_game.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class controls the pause menu screen. It contains functions to switch scenes.
 */
public class PauseController {
    public Play play;
    public Scene menuScene;

    /**
     * This function sets the scene for the menuScene attribute
     *
     * @param menuScene JavaFX scene for Main menu
     */
    public void setMenuScene(Scene menuScene) {
        this.menuScene = menuScene;
    }

    /**
     * This function sets the scene for the play attribute
     *
     * @param play Instance of playable game
     */
    public void setPlay(Play play) {
        this.play = play;
    }

    /**
     * This function quits the game and goes back to the Main menu
     *
     * @param event Action event for "Quit" button press
     */
    @FXML
    void quitGame(ActionEvent event) {
        play.backgroundMusic.pause();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
        play.reset();


    }

    /**
     * This function resumes the game after it is paused
     *
     * @param event Action event for "Resume" button press
     */
    @FXML
    void resumeGame(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(play.gameScene);
        play.timer.start();
        play.backgroundMusic.play();
    }

}
