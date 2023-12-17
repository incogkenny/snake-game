package com.snake_game;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class GameUtil
{
	public static Image getImage(String imagePath)
	{
		Image i = null;
		try {
			i = new Image(imagePath);
		}catch (Exception e)

		{
			System.err.println("ERROR : Specific Image not Found!\n");
			e.printStackTrace();
		}

		return i;
	}

	public static Image rotateImage(ImageView image, double angle){
		image.setRotate(angle);
		SnapshotParameters p = new SnapshotParameters();
		p.setFill(Color.TRANSPARENT);
		return image.snapshot(p, null);

	}

}
