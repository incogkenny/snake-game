package com.snake_game.Controllers;

import com.snake_game.LeaderboardUtil;
import com.snake_game.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Controls the leaderboard screen (scene). It contains functions to interact with the leaderboard table.
 */
public class LeaderboardController implements Initializable {
    /**
     * Stores Scene for Main menu
     */
    public Scene menu_scene;
    /**
     * TableView for Leaderboard screen
     */
    @FXML
    public TableView<Player> leaderboardTable;
    /**
     * List that stores Player records
     */
    public ObservableList<Player> playerData = FXCollections.observableArrayList();
    /**
     * Used in initialize() class
     */
    @FXML
    private ResourceBundle resourceBundle;
    /**
     * Used in initialize() class
     */
    @FXML
    private URL url;
    /**
     * Column for Player names in Leaderboard table
     */
    @FXML
    private TableColumn<Player, String> nameColumn;
    /**
     * Column for Player scores in Leaderboard table
     */
    @FXML
    private TableColumn<Player, Integer> scoreColumn;

    /**
     * Initialises the TableView on the leaderboard screen by adding data to the columns
     *
     * @param url .
     * @param resourceBundle .
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("Score"));
        LeaderboardUtil.loadDataFromCSV(playerData, "src/main/resources/leaderboard.csv");
        leaderboardTable.setItems(playerData);
        leaderboardTable.getSortOrder().add(scoreColumn);

    }

    /**
     * Sets the menuScene attribute
     *
     * @param menu_scene JavaFX scene for Main menu
     */
    public void setMenu_scene(Scene menu_scene) {
        this.menu_scene = menu_scene;
    }

    /**
     * Refreshes the leaderboardTable when new data is added
     */
    public void refreshLeaderboard() {
        playerData.clear();
        initialize(url, resourceBundle);
        leaderboardTable.refresh();
    }

    /**
     * Changes scene to Main Menu
     *
     * @param event Action event for button press
     */
    @FXML
    void backToMenu(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menu_scene);
    }
}
