package com.snake_game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelpController {

    @FXML
    private Button backButton;

    private Scene menuScene;

    public void setMenuScene(Scene scene){
        menuScene = scene;
    }
    @FXML
    void switchToMenu(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(menuScene);
    }

}
