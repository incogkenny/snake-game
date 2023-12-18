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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * This class controls the Main menu screen. It contains functions to switch scenes.
 */
public class MenuController {

    public LeaderboardController leaderboardController;
    public Play play;
    @FXML
    private TextField username;
    @FXML
    private Label namePrompt;
    private Scene settingsScene;
    private Scene leaderboardScene;

    /**
     * This function sets the play attribute.
     *
     * @param play Instance of playable game
     */
    public void setPlay(Play play) {
        this.play = play;
    }

    /**
     * This function sets the scene attribute for the settings screen.
     *
     * @param scene JavaFX Scene for Settings screen
     */
    // sets
    public void setSettingsScene(Scene scene) {
        settingsScene = scene;
    }

    /**
     * This function sets the scene attribute for the leaderboard screen.
     *
     * @param scene JavaFX Scene for Leaderboard screen
     */
    public void setLeaderboardScene(Scene scene) {
        leaderboardScene = scene;
    }

    /**
     * This function changes to the scene for the actual game.
     * If the text box on the Main menu is empty it will not switch scenes and will instead show a flashing label popup to tell player to enter a name.
     * The game cannot be started unless a name is entered.
     *
     * @param event Action event for "Play Game" button press
     */
    @FXML
    void playGame(ActionEvent event) {
        if (username.getText().trim().isEmpty()) {
            namePrompt.setVisible(true);
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), namePrompt);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.setCycleCount(Animation.INDEFINITE);
            fadeTransition.play();
        } else {
            play.playerName = username.getText().trim();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(play.getGameScene());
            play.backgroundMusic = new MusicPlayer("frogger.mp3", true);
            play.game();
        }

    }

    /**
     * This function changes to the Settings screen
     *
     * @param event Action event for "Settings" button press
     */
    @FXML
    void openSettings(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(settingsScene);
    }

    /**
     * This function changes to the Leaderboard screen
     *
     * @param event Action event for "Leaderboard" button press
     */
    @FXML
    void leaderboard(ActionEvent event) {
        leaderboardController.refreshLeaderboard();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(leaderboardScene);

    }

    /**
     * This function exits the game window.
     */
    @FXML
    void exitGame() {
        Platform.exit();
        System.exit(0);
    }


}
