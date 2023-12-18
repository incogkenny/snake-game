package com.snake_game;

import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class contains functions used when loading data into the leaderboard table
 */
public class LeaderboardUtil {
    /**
     * This function checks if the file at the given filePath exists. If it does exist it calls the readDataFromFile function.
     * If it doesn't it creates a new file with the path name from filePath.
     *
     * @param data     List of Player records (High scores)
     * @param filePath project path to csv file
     */
    public static void loadDataFromCSV(ObservableList<Player> data, String filePath) {
        File file = new File("src/main/resources/leaderboard.csv");
        // Checks if file exists
        if (!file.isFile()) {
            try {
                boolean fileCreated = file.createNewFile();
                if (!fileCreated) {
                    throw new IOException("Unable to create leaderboard file at specified path.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            readDataFromFile(data, filePath);
        }

    }

    /**
     * This function reads the data at the filePath into data argument (List of Player records)
     *
     * @param data     List of Player records
     * @param filePath project path to csv file
     */
    private static void readDataFromFile(ObservableList<Player> data, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int score = Integer.parseInt(parts[1].trim());
                    data.add(new Player(name, score));
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
