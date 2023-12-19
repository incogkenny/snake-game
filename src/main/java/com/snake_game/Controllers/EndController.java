package com.snake_game.Controllers;

import com.snake_game.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Used to control the end screen that appears when the game ends. It contains functions to change scenes.
 */
public class EndController {


    /**
     * Instance reference containing instance of playable game
     */
    public Play play;
    /**
     * Stores Scene for Main menu
     */
    public Scene menuScene;

    /**
     * Sets the menuScene attribute
     *
     * @param menuScene JavaFX scene for Main menu
     */
    public void setMenuScene(Scene menuScene) {
        this.menuScene = menuScene;
    }

    /**
     * Sets the play attribute
     *
     * @param play Instance of playable game
     */
    public void setPlay(Play play) {
        this.play = play;
    }

    /**
     * Takes the player back to a new game. Works by switching scene and resetting play instance. This function is the result of a button press.
     *
     * @param event Action event thrown by button press
     */
    @FXML
    void playAgain(ActionEvent event) {
        play.reset();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(play.gameScene);
        play.game();
        play.backgroundMusic.play();
    }

    /**
     * Quits the game and takes the player back to the Main menu. This function is the result of a button press.
     *
     * @param event Action event thrown by button press
     */
    @FXML
    void quit(ActionEvent event) {
        play.reset();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
    }

}
