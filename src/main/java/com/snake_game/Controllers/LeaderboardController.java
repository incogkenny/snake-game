package com.snake_game.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Controls Leaderboard view (leaderboard_view.fxml)
 */
public class LeaderboardController {

    @FXML
    private TableColumn<?, ?> name_field;

    @FXML
    private TableColumn<?, ?> score_field;

    @FXML
    private TableView<?> table;
    public Scene menu_scene;
    public void setMenu_scene(Scene menu_scene) {
        this.menu_scene = menu_scene;
    }

    /**
    * Changes scene to Main Menu
    *
    */
    @FXML
    void backtoMenu(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(menu_scene);
    }
}
