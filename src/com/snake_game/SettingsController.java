package com.snake_game;

import java.io.FileInputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SettingsController {

    @FXML
    private ImageView background;
    @FXML
    private Button backButton;

    @FXML
    private TextField nameForm;

    private Scene menuScene;

    private final ArrayList<Image> images = new ArrayList<>();
    private int imageCounter = 0;

    public SettingsController() throws FileNotFoundException {
        // Adding game backgrounds to list

        images.add(new Image(new FileInputStream("src/com/snake_game/images/UI-background.png")));
        images.add(new Image(new FileInputStream("src/com/snake_game/images/UI-background2.png")));

    }

    public void setMenuScene(Scene scene){
        menuScene = scene;
    }

    @FXML
    void changeBackgroundLeft(ActionEvent event) {
        imageCounter --;
        background.setImage(images.get(imageCounter % images.size()));
    }

    @FXML
    void changeBackgroundRight(ActionEvent event) {
        imageCounter ++;
        background.setImage(images.get(imageCounter % images.size()));
    }


    String getPlayerName() {
        return nameForm.getText();
    }

    @FXML
    void switchToMenu(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
    }

}

