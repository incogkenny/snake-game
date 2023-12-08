package com.snake_game;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Food extends SnakeObject
{
	public Food()	{
		this.state = true;

		this.image = ImageUtil.images.get(String.valueOf(new Random().nextInt(10)));

		this.width = image.getWidth();
		this.height = image.getHeight();

		this.x = (int) (Math.random() * (870 - width + 10));
		this.y = (int) (Math.random() * (560 - height - 40));
	}
/**
 * Checks if food has been eaten
 * 	if it has: The state of the food object is set to false, the snake increases in length and the score is updated.
 * 	Does nothing if food is still on the screen
 */
	public void eaten(MySnake mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle()) && state && mySnake.state)		{
			this.state = false;
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.score += 100;
		}
	}
	@Override
	public void draw(GraphicsContext g)
	{
		g.drawImage(image, x, y);
	}
}
