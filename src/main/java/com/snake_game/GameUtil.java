package com.snake_game;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.net.URL;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;

public class GameUtil
{
	public static Image getImage(String imagePath)
	{
		URL u = GameUtil.class.getClassLoader().getResource(imagePath);
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
//	public static Image rotateImage(final  image, final int degree)
//	{
//	int w = bufferedImage.getWidth();
//	int h = bufferedImage.getHeight();
//	int t = bufferedImage.getColorModel().getTransparency();
//
//	Image i;
//	i = image;
//	i.setRotate
//	Graphics2D graphics2d;
//
//	(graphics2d = (i = new BufferedImage(w, h, t)).createGraphics()).setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//
//	graphics2d.rotate(Math.toRadians(degree), (double) w / 2, (double) h / 2);
//	graphics2d.drawImage(bufferedImage, 0, 0, null);
//	graphics2d.dispose();
//
//	return i;
//
//	}
}
