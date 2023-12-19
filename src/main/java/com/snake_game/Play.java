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
 * Manages the game loop and handles user input. It includes the snake, food, canvas, and scenes.
 */
public class Play {

    /**
     * Allows to draw to canvas
     */
    private GraphicsContext gc;
    /**
     * Stores MySnake instance
     */
    public MySnake mySnake = new MySnake(100, 100);// x , y
    /**
     * Stores Food instance
     */
    public Food food = new Food();
    /**
     * Stores Game Background
     */
    public Image background = ImageUtil.images.get("UI-background");
    /**
     * Plays Background Music
     */
    public MusicPlayer backgroundMusic;
    /**
     * Allows you to write to screen
     */
    public Canvas canvas;
    /**
     * Runs game loop
     */
    public AnimationTimer timer;
    /**
     * Stores Stage for game
     */
    public Stage stage;
    /**
     * Stores Scene for playable game
     */
    public Scene gameScene;
    /**
     * Stores Scene for Pause menu
     */
    public Scene pauseScene;
    /**
     * Stores Scene for End screen
     */
    public Scene endscene;

    /**
     * Stores username entered by player
     */
    public String playerName;

    /**
     * Constructor for the Play class
     * Initialises the canvas, graphics context, scenes, and sets up the key event listener
     */
    public Play() {
        canvas = new Canvas(870, 560);
        gc = canvas.getGraphicsContext2D();

        BorderPane root = new BorderPane(canvas);
        gameScene = new Scene(root);

        gameScene.setOnKeyPressed(this::keyPressed);
    }

    /**
     * Sets the primary stage for the game
     * @param stage The primary stage of the application
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Sets the pause scene for the game
     * @param pauseScene The scene displayed when the game is paused
     */
    public void setPauseScene(Scene pauseScene) {
        this.pauseScene = pauseScene;
    }
    /**
     * Sets the end scene for the game
     * @param scene The scene displayed when the game ends
     */
    public void setEndScene(Scene scene){endscene = scene;}
    /**
     * Returns the game scene
     * @return The game scene
     */
    public Scene getGameScene() {
        return gameScene;
    }

    /**
     * Handles key events for controlling the snake and pausing the game.
     * @param e The KeyEvent object representing the key event.
     */
    public void keyPressed(KeyEvent e) {
        // check the key
        switch (e.getCode()) {
            case UP, W:
                if (!mySnake.down) {
                    mySnake.up = true;
                    mySnake.left = false;
                    mySnake.right = false;

                    mySnake.newImgSnakeHead = ImageUtil.rotateImage(mySnake.IMG_SNAKE_HEAD, -90);
                }
                break;

            case DOWN, S:
                if (!mySnake.up) {
                    mySnake.down = true;
                    mySnake.left = false;
                    mySnake.right = false;

                    mySnake.newImgSnakeHead = ImageUtil.rotateImage(mySnake.IMG_SNAKE_HEAD, 90);
                }
                break;

            case LEFT, A:
                if (!mySnake.right) {
                    mySnake.up = false;
                    mySnake.down = false;
                    mySnake.left = true;

                    mySnake.newImgSnakeHead = ImageUtil.rotateImage(mySnake.IMG_SNAKE_HEAD, -180);

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
                backgroundMusic.pause();
                stage.setScene(pauseScene);
                break;


            default:
                break;
        }
    }

    /**
     * Handles the game loop that constantly updates the state of the game and renders it on the canvas.
     */
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
                        // Creates new food
                    } else {
                        food = new Food();
                    }
                    // Ends game
                } else {
                    backgroundMusic.pause();
                    new MusicPlayer("deathsound.mp3",false);
                    this.stop();

                    // Adds Player name and score to leaderboard file.
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

    /**
     * Resets the game by reinitialising the snake, food, canvas, and game scene.
     */
    public void reset() {
        mySnake.bodyPoints.clear();
        mySnake = new MySnake(100, 100);
        food = new Food();
        canvas = new Canvas(870, 560);
        gc = canvas.getGraphicsContext2D();
        BorderPane root = new BorderPane(canvas);
        gameScene = new Scene(root);
        gameScene.setOnKeyPressed(this::keyPressed);
    }

    /**
     * Draws the score on the graphics context.
     * @param g The graphics context on which the score is drawn.
     */
    public void drawScore(GraphicsContext g) {
        g.setFont(Font.font("SansSerif", FontWeight.BOLD, 30));
        g.setFill(Color.MAGENTA);
        g.fillText("SCORE : " + mySnake.score, 20, 40);
    }
}





