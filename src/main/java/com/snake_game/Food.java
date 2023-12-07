package com.snake_game;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Food extends SnakeObject
{
	public Food()	{
		this.l = true;

		this.i = ImageUtil.images.get(String.valueOf(new Random().nextInt(10)));

		this.w = i.getWidth();
		this.h = i.getHeight();

		this.x = (int) (Math.random() * (870 - w + 10));
		this.y = (int) (Math.random() * (560 - h - 40));
	}

	public void eaten(MySnake mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle()) && l && mySnake.l)		{
			this.l = false;
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.score += 100;
		}
	}
	@Override
	public void draw(GraphicsContext g)
	{
		g.drawImage(i, x, y);
	}
}
