package com.snake_game.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;

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

    /**
    * Changes scene to Main Menu
    *
    */
    @FXML
    void backtoMenu(ActionEvent event) throws IOException {
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/Views/menu-view.fxml"));
        Scene scene = new Scene(menuLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
