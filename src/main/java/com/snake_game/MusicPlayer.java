package com.snake_game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;


public class MusicPlayer{
    private MediaPlayer mediaPlayer;



	public MusicPlayer(String filename, boolean looping) {

		try {
			// gets the URL from the given filename
			URL resource = getClass().getClassLoader().getResource(filename);

			// puts image url into media attribute
            assert resource != null;
            Media media = new Media(resource.toString());

			mediaPlayer = new MediaPlayer(media);

			mediaPlayer.setAutoPlay(true);

			if(looping) { //runs only if looping == true

				mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
			}
			// plays media
			mediaPlayer.play();

		} catch (Exception e) {
            System.err.println("\nCould not find music file");
        }

    }

	public void play(){
		mediaPlayer.play();
	}

	 public void pause(){
		mediaPlayer.pause();
	 }

}
