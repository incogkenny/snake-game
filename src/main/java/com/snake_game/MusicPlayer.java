package com.snake_game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;


/**
 * This class deals with playing music and other sounds in the game
 */
public class MusicPlayer {
    /**
     * Allows music/sound file to be played
     */
    private MediaPlayer mediaPlayer;


    /**
     * This constructor initialises the MusicPlayer object by loading the file into a MediaPlayer object setting its properties.
     * The mediaPlayer is then started.
     *
     * @param filename name of music/sound file
     * @param looping  stores if music/sound needs to loop
     */
    public MusicPlayer(String filename, boolean looping) {

        try {
            // gets the URL from the given filename
            URL resource = getClass().getClassLoader().getResource(filename);

            // puts image url into media attribute
            assert resource != null;
            Media media = new Media(resource.toString());

            mediaPlayer = new MediaPlayer(media);

            mediaPlayer.setAutoPlay(true);

            if (looping) { //runs only if looping == true

                mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
            }
            // plays media
            mediaPlayer.play();

        } catch (Exception e) {
            System.err.println("\nCould not find music file");
        }

    }

    /**
     * This function plays the file in mediaPlayer
     */
    public void play() {
        mediaPlayer.play();
    }

    /**
     * This function pauses the file in mediaPlayer
     */
    public void pause() {
        mediaPlayer.pause();
    }

}
