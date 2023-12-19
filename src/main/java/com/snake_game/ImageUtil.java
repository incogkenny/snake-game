package com.snake_game;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to help with image handling. It contains functions to interact with image files.
 */
public class ImageUtil {
    /**
     * Stores images used within the game
     */
    public static Map<String, Image> images = new HashMap<>();

    static {
        // snake
        images.put("snake-head-right", getImage("snake-head-right.png"));
        images.put("snake-body", getImage("snake-body.png"));
        // obstacles
        images.put("0", getImage("food-kiwi.png"));
        images.put("1", getImage("food-lemon.png"));
        images.put("2", getImage("food-litchi.png"));
        images.put("3", getImage("food-mango.png"));
        images.put("4", getImage("food-apple.png"));
        images.put("5", getImage("food-banana.png"));
        images.put("6", getImage("food-blueberry.png"));
        images.put("7", getImage("food-cherry.png"));
        images.put("8", getImage("food-durian.png"));
        images.put("9", getImage("food-grape.png"));
        images.put("10", getImage("food-grapefruit.png"));
        images.put("11", getImage("food-peach.png"));
        images.put("12", getImage("food-pear.png"));
        images.put("13", getImage("food-orange.png"));
        images.put("14", getImage("food-pineapple.png"));
        images.put("15", getImage("food-strawberry.png"));
        images.put("16", getImage("food-watermelon.png"));
        images.put("UI-background", getImage("UI-background.png"));
        images.put("UI-background2", getImage("UI-background2.png"));
        images.put("game-scene-01", getImage("end.png"));
    }

    /**
     * Gets a file as an Image object
     *
     * @param imagePath project path from resources to image
     * @return the passed in imagePath as an Image object
     */
    public static Image getImage(String imagePath) {
        Image image = null;
        try {
            image = new Image(imagePath);
        } catch (Exception e) {
            System.err.println("ERROR : Specific Image not Found!\n");
            e.printStackTrace();
        }

        return image;
    }

    /**
     * Rotates a given image
     *
     * @param image ImageView being rotated
     * @param angle the degree to rotate the image by
     * @return rotated image as an Image object
     */
    public static Image rotateImage(ImageView image, double angle) {
        image.setRotate(angle);
        SnapshotParameters p = new SnapshotParameters();
        p.setFill(Color.TRANSPARENT);
        return image.snapshot(p, null);

    }
}
