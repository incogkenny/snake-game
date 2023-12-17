package com.snake_game;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MusicPlayer extends Thread {
	private String filename;
	private AdvancedPlayer player;
	private boolean looping;
	private boolean backgroundMusicPlaying;
	private boolean paused;

	public MusicPlayer(String filename, boolean looping) {
		this.filename = filename;
		this.looping = looping;
		this.backgroundMusicPlaying = false;
		this.paused = false;
	}

	@Override
	public void run() {
		super.run();
		try {
			while (looping) {
				FileInputStream fileInputStream = new FileInputStream(filename);
				BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

				player = new AdvancedPlayer(bufferedInputStream);
				player.setPlayBackListener(new PlaybackListener() {
					@Override
					public void playbackFinished(PlaybackEvent evt) {
						if (looping && !paused) {
							stopPlayback();  // Stop the current playback
							restart();       // Restart from the beginning
						}
					}
				});

				player.play();
				fileInputStream.close();
			}
		} catch (JavaLayerException | IOException e) {
			e.printStackTrace();
		}
	}

	public void playSound() {
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

			player = new AdvancedPlayer(bufferedInputStream);
			player.play();

			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopPlayback() {
		if (player != null) {
			player.close();
		}
	}

	public void stopBackgroundMusic() {
		looping = false;
		stopPlayback();
		backgroundMusicPlaying = false;
		paused = false;
	}

	public void pauseBackgroundMusic() {
		paused = true;
		looping = false;
		stopPlayback();  // Pause by stopping the current playback
	}

	private void restart() {
		backgroundMusicPlaying = true;
	}
}
