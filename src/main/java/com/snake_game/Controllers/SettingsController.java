package com.snake_game.Controllers;

import com.snake_game.Play;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SettingsController {

    @FXML
    private ImageView background;
    private Scene menuScene;
    private final ArrayList<Image> images = new ArrayList<>();
    private int imageCounter = 0;

    public void setPlay(Play play) {
        this.play = play;
    }

    public Play play;

    public SettingsController() throws FileNotFoundException {
        // Adding game backgrounds to list

        images.add(new Image(new FileInputStream("src/main/resources/images/UI-background.png")));
        images.add(new Image(new FileInputStream("src/main/resources/images/UI-background2.png")));
        images.add(new Image(new FileInputStream("src/main/resources/images/UI-background3.png")));

    }

    public void setMenuScene(Scene scene){
        menuScene = scene;
    }

    @FXML
    void changeBackgroundLeft() {
        imageCounter --;
        background.setImage(images.get(imageCounter % images.size()));
        play.background = images.get(imageCounter % images.size());
    }

    @FXML
    void changeBackgroundRight() {
        imageCounter ++;
        background.setImage(images.get(imageCounter % images.size()));
        play.background = images.get(imageCounter % images.size());
    }

    @FXML
    void switchToMenu(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
    }

}

