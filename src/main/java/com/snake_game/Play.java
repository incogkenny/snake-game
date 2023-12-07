package com.snake_game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.text.Font;




/**
 * 
 *
 * @code Play the game
 * @author Sigurður Sigurðardóttir
 * @version Not Sure
 */ 

public class Play extends Application
{

	//@Serial
//	private static final long serialVersionUID = -3641221053272056036L;

	public MySnake mySnake = new MySnake(100, 100);// x , y
	public Food food = new Food();

	public Image background = ImageUtil.images.get("UI-background");
	public Image fail = ImageUtil.images.get("game-scene-01");

	public Canvas canvas;
	private GraphicsContext gc;

	public void start(Stage stage){
		canvas = new Canvas(870, 560);
		gc = canvas.getGraphicsContext2D();

		BorderPane root = new BorderPane(canvas);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Snake");

		scene.setOnKeyPressed(e -> mySnake.keyPressed(e));
		stage.show();
		game();
	}

	public void game()
	{
		new AnimationTimer(){
			@Override
			public void handle(long l) {
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				gc.drawImage(background, 0, 0);

				// Determine the state of the game.
				if (mySnake.l)
				{
					mySnake.draw(gc);
					if (food.l)
					{
						food.draw(gc);
						food.eaten(mySnake);
					} else
					{
						food = new Food();
					}
				} else
				{
					gc.drawImage(fail, 0, 0);
				}
				drawScore(gc);


			}
			}.start();

	}

	public void drawScore(GraphicsContext g)
	{
		g.setFont(Font.font("SansSerif", FontWeight.BOLD, 30));
		g.setFill(Color.MAGENTA);
		g.fillText("SCORE : " + mySnake.score, 20, 40);
	}

	public static void main(String[] args)
	{
		MusicPlayer.getMusicPlay("src/main/resources/sounds/frogger.mp3");
		launch(args);



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
