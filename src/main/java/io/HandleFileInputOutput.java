package main.java.io;

import main.java.ai.GameLogic;
import main.java.model.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class HandleFileInputOutput {
    private static final Properties leaderboard = new Properties();
    private static final Properties words = new Properties();
    private static final Scanner input = new Scanner(System.in);

    public static void loadResources() {
        try {
            leaderboard.load(new FileInputStream("src/main/resources/leaderboards.properties"));
            words.load(new FileInputStream("src/main/resources/words.properties"));
            for (Map.Entry<Object, Object> entry : words.entrySet()) {
                GameLogic.getWords().add(entry.getValue().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void writeScore(User user) throws IOException {
        if (user.getScore() > Integer.parseInt(leaderboard.getProperty(user.getNickName()))) {
            leaderboard.setProperty(user.getNickName(), Integer.toString(user.getScore()));
            leaderboard.store(new FileOutputStream("C:/Users/HP/Documents/Java Projects/HangmanGame/src/main/resources/leaderboards.properties"), "");
        }
    }

    public static void viewLeaderboards() {
        System.out.println("\nYou want to have a peek at Leaderboards (yes/no) :");
        char answer = input.next().toLowerCase().charAt(0);
        if (answer != 'y') {
            return;
        }
        for (Map.Entry<Object, Object> e : leaderboard.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

}

