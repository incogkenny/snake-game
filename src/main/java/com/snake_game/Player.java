package com.snake_game;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public final class Player {
    public SimpleStringProperty Name;
    public SimpleIntegerProperty Score;

    public Player(String name, Integer score) {
        this.Name = new SimpleStringProperty(name);
        this.Score = new SimpleIntegerProperty(score);
    }

    public String getName(){return Name.get();}

    public int getScore(){return Score.get();}

    public void setName(String name){this.Name = new SimpleStringProperty(name);}

    public void setScore(int score) {
        this.Score = new SimpleIntegerProperty(score);
    }
}
