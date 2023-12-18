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
 * This class controls the settings screen. It includes functions to change settings of the game
 */
public class SettingsController {

    @FXML
    private ImageView background;

    private Scene menuScene;
    private final ArrayList<Image> images = new ArrayList<>();
    private int imageCounter = 0;
    public Play play;


    /**
     * This function sets the play attribute
     *
     * @param play Instance of the playable game
     */
    public void setPlay(Play play) {
        this.play = play;
    }

    /**
     * This constructor adds backgrounds to list, so they can be easier accessed within class
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
     * This function sets the menuScene attribute
     *
     * @param scene JavaFX scene for Main menu
     */
    public void setMenuScene(Scene scene) {
        menuScene = scene;
    }

    /**
     * This function changes the background for the game. (It goes to the previous image in the images list)
     */
    @FXML
    void changeBackgroundLeft() {
        imageCounter--;
        background.setImage(images.get(imageCounter % images.size()));
        play.background = images.get(imageCounter % images.size());
    }

    /**
     * This function changes the background for the game. (It goes to the next image in the images list)
     */
    @FXML
    void changeBackgroundRight() {
        imageCounter++;
        background.setImage(images.get(imageCounter % images.size()));
        play.background = images.get(imageCounter % images.size());
    }

    /**
     * This function changes the game to easy mode (reduced speed)
     */
    @FXML
    void easyMode() {
        play.mySnake.setSpeed_XY(3);
    }

    /**
     * This function changes the game to hard mode (increases speed)
     */
    @FXML
    void hardMode() {
        play.mySnake.setSpeed_XY(5);
    }

    /**
     * This function changes the game to normal mode (original speed)
     */
    @FXML
    void normalMode() {
        play.mySnake.setSpeed_XY(4);
    }

    /**
     * This function switches the scene to the Main menu
     *
     * @param event Action event for back button
     */
    @FXML
    void switchToMenu(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
    }

}

