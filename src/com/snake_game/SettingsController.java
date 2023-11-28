package com.snake_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SettingsController {

    @FXML
    private ImageView background;
    @FXML
    private Button backButton;

    @FXML
    private Button leftarrow;

    @FXML
    private TextField nameForm;

    @FXML
    private Button rightarrow;

    private Scene menuScene;

    public void setMenuScene(Scene scene){
        menuScene = scene;
    }

    @FXML
    void changeBackground(ActionEvent event) {

    }

    @FXML
    void changePlayerName(ActionEvent event) {

    }

    @FXML
    void switchToMenu(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
    }

}

