package com.snake_game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

        // Scene Controllers get access to other scenes
        MenuController menuController = menuLoader.getController();
        menuController.setSettingsScene(scene2);
        menuController.setHowToPlayScene(scene3);

        SettingsController settingsController = settingsLoader.getController();
        settingsController.setMenuScene(scene1);

        HelpController helpController = helpLoader.getController();
        helpController.setMenuScene(scene1);

        stage.setTitle("Snake");
        stage.setScene(scene1);
        stage.setResizable(false);

        stage.show();
    }
}
