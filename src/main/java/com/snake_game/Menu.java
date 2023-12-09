package com.snake_game;

import com.snake_game.Controllers.HelpController;
import com.snake_game.Controllers.MenuController;
import com.snake_game.Controllers.SettingsController;
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

        FXMLLoader helpLoader = new FXMLLoader(getClass().getResource("/Views/help-view.fxml"));
        Scene scene3 = new Scene(helpLoader.load());

        // Instantiates Game object
        Play game = new Play();
        // Scene Controllers get access to other scenes and the Play() instance
        MenuController menuController = menuLoader.getController();
        menuController.setPlay(game);
        menuController.setSettingsScene(scene2);
        menuController.setHowToPlayScene(scene3);

        SettingsController settingsController = settingsLoader.getController();
        settingsController.setPlay(game);
        settingsController.setMenuScene(scene1);


        HelpController helpController = helpLoader.getController();
        helpController.setMenuScene(scene1);


        stage.setTitle("Snake");
        stage.getIcons().add(new Image("snake-logo.png"));
        stage.setScene(scene1);
        stage.setResizable(false);

        stage.show();
    }
}
