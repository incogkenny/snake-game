package com.snake_game;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class SnakeObject {
    int x;
    int y;
    Image image;
    double width;
    double height;

    public boolean state;


    public abstract void draw(GraphicsContext g);

    public Rectangle2D getRectangle() {
        return new Rectangle2D(x, y, width, height);
    }
}
