package com.snake_game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * @author Sigurður Sigurðardóttir
 * @version Not Sure
 * @code Play the game
 */

public class Play {

    private GraphicsContext gc;
    public MySnake mySnake = new MySnake(100, 100);// x , y
    public Food food = new Food();
    public Image background = ImageUtil.images.get("UI-background");
    public MusicPlayer backgroundMusic = new MusicPlayer("src/main/resources/sounds/frogger.mp3",true);
    public MusicPlayer biteSound = new MusicPlayer("src/main/resources/sounds/bite.mp3", false);
    public Canvas canvas;
    public AnimationTimer timer;
    public Stage stage;
    public Scene gameScene;
    public Scene pauseScene;
    public Scene endscene;

    public String playerName;

    public Play() {
        canvas = new Canvas(870, 560);
        gc = canvas.getGraphicsContext2D();

        BorderPane root = new BorderPane(canvas);
        gameScene = new Scene(root);

        gameScene.setOnKeyPressed(this::keyPressed);
        //stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setPauseScene(Scene pauseScene) {
        this.pauseScene = pauseScene;
    }
    public void setEndScene(Scene scene){endscene = scene;}
    public Scene getGameScene() {
        return gameScene;
    }


    public void keyPressed(KeyEvent e) {
        // check the key
        switch (e.getCode()) {
            case UP, W:
                if (!mySnake.down) {
                    mySnake.up = true;
                    mySnake.left = false;
                    mySnake.right = false;

                    mySnake.newImgSnakeHead = GameUtil.rotateImage(mySnake.IMG_SNAKE_HEAD, -90);
                }
                break;

            case DOWN, S:
                if (!mySnake.up) {
                    mySnake.down = true;
                    mySnake.left = false;
                    mySnake.right = false;

                    mySnake.newImgSnakeHead = GameUtil.rotateImage(mySnake.IMG_SNAKE_HEAD, 90);
                }
                break;

            case LEFT, A:
                if (!mySnake.right) {
                    mySnake.up = false;
                    mySnake.down = false;
                    mySnake.left = true;

                    mySnake.newImgSnakeHead = GameUtil.rotateImage(mySnake.IMG_SNAKE_HEAD, -180);

                }
                break;

            case RIGHT, D:
                if (!mySnake.left) {
                    mySnake.up = false;
                    mySnake.down = false;
                    mySnake.right = true;

                    mySnake.newImgSnakeHead = mySnake.IMG_SNAKE_HEAD.getImage();
                }
                break;
            case ESCAPE:
                timer.stop();
                backgroundMusic.pauseBackgroundMusic();
                stage.setScene(pauseScene);
                break;


            default:
                break;
        }
    }

    public void game() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.drawImage(background, 0, 0);

                // Constantly determines the state of the game.#
                // First checks if snake is alive
                if (mySnake.state) {
                    mySnake.draw(gc);
                    // Checks food
                    if (food.state) {
                        food.draw(gc);
                        food.eaten(mySnake);
                    } else {

                        // biteSound.playSound();
                        food = new Food();
                    }
                } else {
                    backgroundMusic.stopBackgroundMusic();
                    this.stop();

                    try {

                        String entry = playerName + "," + mySnake.score + "\n";
                        Files.write(Paths.get("src/main/resources/leaderboard.csv"), entry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        System.err.println("Error: File could not be written to");
                        e.printStackTrace();
                    }
                    stage.setScene(endscene);
                }
                drawScore(gc);


            }
        };
        timer.start();

    }

    public void reset(){
        mySnake.bodyPoints.clear();
        mySnake = new MySnake(100, 100);
        food = new Food();
        canvas = new Canvas(870, 560);
        gc = canvas.getGraphicsContext2D();
        BorderPane root = new BorderPane(canvas);
        gameScene = new Scene(root);
        gameScene.setOnKeyPressed(this::keyPressed);
        backgroundMusic = new MusicPlayer("src/main/resources/sounds/frogger.mp3",true);
    }

    public void drawScore(GraphicsContext g) {
        g.setFont(Font.font("SansSerif", FontWeight.BOLD, 30));
        g.setFill(Color.MAGENTA);
        g.fillText("SCORE : " + mySnake.score, 20, 40);
    }
}
