package com.snake_game;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the snake (player) object in the game. It extends the SnakeObject class
 * * and implements the movable interface.
 */
public class MySnake extends SnakeObject {

    /**
     * Amount that the snake moves per tick of the timer
     */
    private int speed_XY;
    /**
     * Length of snake
     */
    private int length;
    /**
     * Used when drawing snake
     */
    private final double num;
    /**
     * Game Score
     */
    public int score = 0;

    /**
     * Image for Head of snake
     */
    public final ImageView IMG_SNAKE_HEAD = new ImageView(ImageUtil.images.get("snake-head-right"));

    /**
     * Stores Snake body parts
     */
    public List<Point2D> bodyPoints = new LinkedList<>();

    /**
     * Stores Snake head after being rotated
     */
    public Image newImgSnakeHead;
    /**
     * When Snake head is facing up
     */
    boolean up, /**
     * When Snake head is facing down
     */
    down, /**
     * When Snake head is facing left
     */
    left, /**
     * When Snake head is facing right
     */
    right = true;

    /**
     * Initialises attributes in the class
     *
     * @param x refers to where snake is spawned on x-axis
     * @param y refers to where snake is spawned on y-axis
     */
    public MySnake(int x, int y) {
        this.state = true;
        this.x = x;
        this.y = y;
        this.image = ImageUtil.images.get("snake-body");
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.speed_XY = 4;
        this.length = 1;
        this.num = width / 5;
        newImgSnakeHead = IMG_SNAKE_HEAD.getImage();
    }

    /**
     * Sets speed_XY attribute
     *
     * @param speed_XY amount of pixels the snake moves per tick of the timer
     */
    public void setSpeed_XY(int speed_XY) {
        this.speed_XY = speed_XY;
    }

    /**
     * Returns length of snake
     *
     * @return length of snake (body + head)
     */
    public int getLength() {
        return length;
    }

    /**
     * Changes the length of snake
     *
     * @param length length of snake (body + head)
     */
    public void changeLength(int length) {
        this.length = length;
    }


    /**
     * Moves the snake based on the direction its facing
     */
    public void move() {
        if (up) {
            y -= speed_XY;
        } else if (down) {
            y += speed_XY;
        } else if (left) {
            x -= speed_XY;
        } else if (right) {
            x += speed_XY;
        }

    }

    /**
     * Draws the snake on the graphics context.
     *
     * @param g The graphics context on which the snake is drawn.
     */
    @Override
    public void draw(GraphicsContext g) {
        outofBounds();
        eatBody();

        bodyPoints.add(new Point2D(x, y));

        if (bodyPoints.size() == (this.length + 1) * num) {
            bodyPoints.removeFirst();
        }
        g.drawImage(newImgSnakeHead, x, y);
        drawBody(g);

        move();
    }

    /**
     * Checks if the snake has run into (eaten) a part of its body
     */
    public void eatBody() {
        for (Point2D point : bodyPoints) {
            for (Point2D point2 : bodyPoints) {
                if (point.equals(point2) && point != point2) {
                    this.state = false;
                    break;
                }
            }
        }
    }

    /**
     * Draws the body of the snake on the graphics context.
     *
     * @param g The graphics context on which the snake's body is drawn.
     */
    public void drawBody(GraphicsContext g) {
        int length = (int) (bodyPoints.size() - 1 - num);

        for (int i = length; i >= num; i -= (int) num) {
            Point2D point = bodyPoints.get(i);
            g.drawImage(this.image, point.getX(), point.getY());
        }
    }

    /**
     * Checks if the snake is out of bounds and sets its state accordingly.
     */
    private void outofBounds() {
        boolean xOut = (x <= 0 || x >= (870 - width));
        boolean yOut = (y <= 0 || y >= (560 - height));
        if (xOut || yOut) {
            state = false;
        }
    }
}
