package com.snake_game.Controllers;

import com.snake_game.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Controls the settings screen. It includes functions to change settings of the game
 */
public class SettingsController {

    /**
     * Represents Image changer on Settings screen
     */
    @FXML
    private ImageView background;

    /**
     * Stores Scene for Main menu
     */
    private Scene menuScene;
    /**
     * List storing images to choose
     */
    private final ArrayList<Image> images = new ArrayList<>();
    /**
     * Used to select images
     */
    private int imageCounter = 0;
    /**
     * Stores instance of playable game
     */
    public Play play;


    /**
     * Sets the play attribute
     *
     * @param play Instance of the playable game
     */
    public void setPlay(Play play) {
        this.play = play;
    }

    /**
     * Adds backgrounds to list, so they can be easier accessed within class
     *
     * @throws FileNotFoundException thrown when backgrounds aren't found
     */
    public SettingsController() throws FileNotFoundException {
        // Adding game backgrounds to list

        images.add(new Image(new FileInputStream("src/main/resources/images/UI-background.png")));
        images.add(new Image(new FileInputStream("src/main/resources/images/UI-background2.png")));
        images.add(new Image(new FileInputStream("src/main/resources/images/UI-background3.png")));

    }

    /**
     * Sets the menuScene attribute
     *
     * @param scene JavaFX scene for Main menu
     */
    public void setMenuScene(Scene scene) {
        menuScene = scene;
    }

    /**
     * Changes the background for the game. (It goes to the previous image in the images list)
     */
    @FXML
    void changeBackgroundLeft() {
        imageCounter--;
        background.setImage(images.get(imageCounter % images.size()));
        play.background = images.get(imageCounter % images.size());
    }

    /**
     * Changes the background for the game. (It goes to the next image in the images list)
     */
    @FXML
    void changeBackgroundRight() {
        imageCounter++;
        background.setImage(images.get(imageCounter % images.size()));
        play.background = images.get(imageCounter % images.size());
    }

    /**
     * Changes the game to easy mode (reduced speed)
     */
    @FXML
    void easyMode() {
        play.mySnake.setSpeed_XY(3);
    }

    /**
     * Changes the game to hard mode (increases speed)
     */
    @FXML
    void hardMode() {
        play.mySnake.setSpeed_XY(5);
    }

    /**
     * Changes the game to normal mode (original speed)
     */
    @FXML
    void normalMode() {
        play.mySnake.setSpeed_XY(4);
    }

    /**
     * Switches the scene to the Main menu
     *
     * @param event Action event for back button
     */
    @FXML
    void switchToMenu(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
    }

}

