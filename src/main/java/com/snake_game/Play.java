package com.snake_game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * @author Sigurður Sigurðardóttir
 * @version Not Sure
 * @code Play the game
 */

public class Play {

    //@Serial
//	private static final long serialVersionUID = -3641221053272056036L;

    public MySnake mySnake = new MySnake(100, 100);// x , y
    public Food food = new Food();

    public Image background = ImageUtil.images.get("UI-background");
    public Image fail = ImageUtil.images.get("game-scene-01");

    public Canvas canvas;
    private GraphicsContext gc;

    public Scene getScene() {
        return scene;
    }

    public Scene scene;

    public Play() {
        canvas = new Canvas(870, 560);
        gc = canvas.getGraphicsContext2D();

        BorderPane root = new BorderPane(canvas);
        scene = new Scene(root);
        //stage.setScene(scene);
        //stage.setTitle("Snake");

        scene.setOnKeyPressed(e -> mySnake.keyPressed(e));
        //stage.show();
    }

    public void game() {
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.drawImage(background, 0, 0);

                // Constantly determines the state of the game.#
                // First checks if snake is alive
                if (mySnake.state) {
                    mySnake.draw(gc);
                    // Checks if food
                    if (food.state) {
                        food.draw(gc);
                        food.eaten(mySnake);
                    } else {
                        food = new Food();
                    }
                } else {
                    gc.drawImage(fail, 0, 0);
                }
                drawScore(gc);


            }
        }.start();

    }

    public void drawScore(GraphicsContext g) {
        g.setFont(Font.font("SansSerif", FontWeight.BOLD, 30));
        g.setFill(Color.MAGENTA);
        g.fillText("SCORE : " + mySnake.score, 20, 40);
    }

    public static void main(String[] args) {
        MusicPlayer.getMusicPlay("src/main/resources/sounds/frogger.mp3");


    }
/*	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		// frame.setSize(400,600);
		frame.setBounds(450, 200, 920, 600);
		// frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SnakePanel panel = new SnakePanel();
		frame.add(panel);

		frame.setVisible(true);

		// Play the background music.
		MusicPlayer.getMusicPlay("resource\\music\\background.mp3");
	} 
*/
}
