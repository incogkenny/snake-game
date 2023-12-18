package com.snake_game;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This class represents a player's score record.
 * It uses SimpleStringProperty for the player's name and SimpleIntegerProperty for the score.
 */
public final class Player {
    public SimpleStringProperty Name;
    public SimpleIntegerProperty Score;

    /**
     * Constructor for the Player class.
     * @param name The name of the player.
     * @param score The score of the player.
     */
    public Player(String name, Integer score) {
        this.Name = new SimpleStringProperty(name);
        this.Score = new SimpleIntegerProperty(score);
    }

    /**
     * Gets the name of the player.
     * @return The name of the player.
     */
    public String getName() {
        return Name.get();
    }

    /**
     * Gets the score of the player.
     * @return The score of the player.
     */
    public int getScore() {
        return Score.get();
    }

    /**
     * Sets the name of the player.
     * @param name The new name of the player.
     */
    public void setName(String name) {
        this.Name = new SimpleStringProperty(name);
    }

    /**
     * Sets the score of the player.
     * @param score The new score of the player.
     */
    public void setScore(int score) {
        this.Score = new SimpleIntegerProperty(score);
    }
}
