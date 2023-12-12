package com.snake_game;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.util.LinkedList;
import java.util.List;

public class MySnake extends SnakeObject implements movable {

    private int speed_XY;
    private int length;
    private double num; // ?
    public int score = 0;

    private static final ImageView IMG_SNAKE_HEAD = new ImageView(ImageUtil.images.get("snake-head-right"));

    public static List<Point2D> bodyPoints = new LinkedList<>();

    private static Image newImgSnakeHead;
    boolean up, down, left, right = true;

    public MySnake(int x, int y) {
        this.state = true;
        this.x = x;
        this.y = y;
        this.image = ImageUtil.images.get("snake-body");
        this.width = image.getWidth();
        this.height = image.getHeight();

        this.speed_XY = 4;
        this.length = 1;

        /*
         * Attention : ?
         */
        this.num = width / 5;
        newImgSnakeHead = IMG_SNAKE_HEAD.getImage();

    }

    public void setSpeed_XY(int speed_XY) {
        this.speed_XY = speed_XY;
    }
    public int getLength() {
        return length;
    }

    public void changeLength(int length) {
        this.length = length;
    }

    public void keyPressed(KeyEvent e) {
        // check the key
        switch (e.getCode()) {
            case UP:
                if (!down) {
                    up = true;
                    down = false;
                    left = false;
                    right = false;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                }
                break;

            case DOWN:
                if (!up) {
                    up = false;
                    down = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case LEFT:
                if (!right) {
                    up = false;
                    down = false;
                    left = true;
                    right = false;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);

                }
                break;

            case RIGHT:
                if (!left) {
                    up = false;
                    down = false;
                    left = false;
                    right = true;

                    newImgSnakeHead = IMG_SNAKE_HEAD.getImage();
                }

            default:
                break;
        }
    }


    public void move() {
        // let the snake move
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

    @Override
    public void draw(GraphicsContext g) {
        outofBounds();
        eatBody();

        bodyPoints.add(new Point2D(x, y));

        if (bodyPoints.size() == (this.length + 1) * num) {
            bodyPoints.remove(0);
        }
        g.drawImage(newImgSnakeHead, x, y);
        drawBody(g);

        move();
    }
/** Checks if the snake has run into (eaten) a part of its body*/
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

    public void drawBody(GraphicsContext g) {
        int length = (int) (bodyPoints.size() - 1 - num);

        for (int i = length; i >= num; i -= (int) num) {
            Point2D point = bodyPoints.get(i);
            g.drawImage(this.image, point.getX(), point.getY());
        }
    }

    private void outofBounds() {
        boolean xOut = (x <= 0 || x >= (870 - width));
        boolean yOut = (y <= 0 || y >= (560 - height));
        if (xOut || yOut) {
            state = false;
        }
    }
}
