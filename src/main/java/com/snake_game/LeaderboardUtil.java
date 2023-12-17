package com.snake_game;

import com.snake_game.Controllers.LeaderboardController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeaderboardUtil {
    public static void loadDataFromCSV(LeaderboardController leaderboardController, String filePath) {
        File file = new File("src/main/resources/leaderboard.csv");
        // Checks if file exists
        if (!file.isFile()){
            try {
                boolean fileCreated = file.createNewFile();
                if (!fileCreated){throw new IOException("Unable to create leaderboard file at specified path.");}
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        else{
            try (BufferedReader reader = new BufferedReader(new FileReader((filePath)))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String name = parts[0].trim();
                        int score = Integer.parseInt(parts[1].trim());
                        leaderboardController.playerData.add(new Player(name, score));
                    } else {
                        System.err.println("Invalid CSV Format, Each line in the CSV file must have two values (Name, Score).");
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error Reading CSV: An error occurred while reading the CSV file.");
                e.printStackTrace();
            }
        }

    }

}
