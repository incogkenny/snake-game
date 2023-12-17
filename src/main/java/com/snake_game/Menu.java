package com.snake_game;

import com.snake_game.Controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Loads fxml files into scenes
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/Views/menu-view.fxml"));
        Scene scene1 = new Scene(menuLoader.load());

        FXMLLoader settingsLoader = new FXMLLoader(getClass().getResource("/Views/settings-view.fxml"));
        Scene scene2 = new Scene(settingsLoader.load());

        FXMLLoader leaderboardLoader = new FXMLLoader(getClass().getResource("/Views/leaderboard-view.fxml"));
        Scene scene3 = new Scene(leaderboardLoader.load());

        FXMLLoader pauseLoader = new FXMLLoader(getClass().getResource("/Views/pause-view.fxml"));
        Scene scene4 = new Scene(pauseLoader.load());

        FXMLLoader endLoader = new FXMLLoader(getClass().getResource("/Views/end-view.fxml"));
        Scene scene5 = new Scene(endLoader.load());

        // Instantiates Game object
        Play game = new Play();
        game.setStage(stage);
        // Scene Controllers get access to other scenes and the Play() instance
        MenuController menuController = menuLoader.getController();
        menuController.setPlay(game);
        menuController.setSettingsScene(scene2);
        menuController.setLeaderboardScene(scene3);

        SettingsController settingsController = settingsLoader.getController();
        settingsController.setPlay(game);
        settingsController.setMenuScene(scene1);

        LeaderboardController leaderboardController = leaderboardLoader.getController();
        leaderboardController.setMenu_scene(scene1);
        menuController.leaderboardController = leaderboardController;

        PauseController pauseController = pauseLoader.getController();
        pauseController.setMenuScene(scene1);
        pauseController.setPlay(game);
        game.setPauseScene(scene4);

        EndController endController = endLoader.getController();
        endController.setMenuScene(scene1);
        endController.setPlay(game);
        game.setEndScene(scene5);




        stage.setTitle("Snake");
        stage.getIcons().add(new Image("snake-logo.png"));
        stage.setScene(scene1);
        stage.setResizable(false);

        stage.show();
    }
}
