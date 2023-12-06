package com.snake_game;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LeaderboardController {

    @FXML
    private TableColumn<?, ?> name_field;

    @FXML
    private TableColumn<?, ?> score_field;

    @FXML
    private TableView<?> table;

}
