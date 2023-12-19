package com.snake_game.Controllers;

import com.snake_game.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controls the pause menu screen. It contains functions to switch scenes.
 */
public class PauseController {
    /**
     * Instance reference containing instance of playable game
     */
    public Play play;
    /**
     * Stores Scene for Main menu
     */
    public Scene menuScene;

    /**
     * Sets the scene for the menuScene attribute
     *
     * @param menuScene JavaFX scene for Main menu
     */
    public void setMenuScene(Scene menuScene) {
        this.menuScene = menuScene;
    }

    /**
     * Sets the scene for the play attribute
     *
     * @param play Instance of playable game
     */
    public void setPlay(Play play) {
        this.play = play;
    }

    /**
     * Quits the game and goes back to the Main menu
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
     * Resumes the game after it is paused
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
