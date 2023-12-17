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
 * Controls Leaderboard view (leaderboard_view.fxml)
 */
public class LeaderboardController implements Initializable {
    public Scene menu_scene;
    @FXML
    private ResourceBundle resourceBundle;
    @FXML
    private URL url;
    @FXML
    private TableColumn<Player, String> nameColumn;
    @FXML
    private TableColumn<Player, Integer> scoreColumn;
    @FXML
    public TableView<Player> leaderboardTable;
    public ObservableList<Player> playerData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("Score"));
        LeaderboardUtil.loadDataFromCSV(this, "src/main/resources/leaderboard.csv");
        leaderboardTable.setItems(playerData);
        leaderboardTable.getSortOrder().add(scoreColumn);

    }

    public void setMenu_scene(Scene menu_scene) {
        this.menu_scene = menu_scene;
    }

    public void refreshLeaderboard(){
        playerData.clear();
        initialize(url, resourceBundle);
        leaderboardTable.refresh();
    }

    /**
     * Changes scene to Main Menu
     */
    @FXML
    void backtoMenu(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(menu_scene);
    }
    }
