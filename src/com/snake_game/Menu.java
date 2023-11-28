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
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("menu-view.fxml"));
        Scene scene1 = new Scene(menuLoader.load());

        FXMLLoader settingsLoader = new FXMLLoader(getClass().getResource("settings-view.fxml"));
        Scene scene2 = new Scene(settingsLoader.load());

        MenuController menuController = menuLoader.getController();
        menuController.setSettingsScene(scene2);

        SettingsController settingsController = settingsLoader.getController();
        settingsController.setMenuScene(scene1);

        stage.setTitle("Snake");
        stage.setScene(scene1);
        stage.setResizable(false);

        stage.show();
    }
}
