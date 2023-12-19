package com.snake_game;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


/**
 * Skeleton for objects that are drawn in the game
 */
public abstract class SnakeObject {
    /**
     * X coordinate
     */
    int x;
    /**
     * Y coordinate
     */
    int y;
    /**
     * Image to be drawn
     */
    Image image;
    /**
     * Width of image
     */
    double width;
    /**
     * Height of image
     */
    double height;

    /**
     * State of object: true means alive, false means dead
     */
    public boolean state;


    /**
     * draws to Canvas
     *
     * @param g Allows Canvas to be drawn to
     */
    public abstract void draw(GraphicsContext g);

    /**
     * @return Rectangle "hitbox" for image
     */
    public Rectangle2D getRectangle() {
        return new Rectangle2D(x, y, width, height);
    }
}
