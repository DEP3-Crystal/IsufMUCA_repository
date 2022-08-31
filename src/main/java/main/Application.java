package main.java.main;

import main.java.ai.GameLogic;
import main.java.io.HandleFileInputOutput;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        GameLogic.promptUserData();
        while (GameLogic.getWordCount() > 0) {

            GameLogic.pickRandomWord();
            GameLogic.initMap();
            GameLogic.buildWord();

            while (!GameLogic.wordIsComplete() && GameLogic.getCurrentUser().getCurrentChances() > 0) {

                GameLogic.displayCurrentWorldInfo();
                GameLogic.checkCorrect(GameLogic.promptInput());
                GameLogic.buildWord();

                try {
                    GameLogic.getCurrentUser().printStatus();
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }

                if (GameLogic.getCurrentUser().getCurrentChances() == 0) {
                    break;
                }
                GameLogic.showWrongGuesses();
            }//end while

            if (GameLogic.wordIsComplete()) {
                GameLogic.increaseUserScores();
                System.out.println("SUCCESS ! NEXT WORD !");
                System.out.println("----------------------------------------------");
            } else {
                break;
            }

            GameLogic.clearCashed();

        }//end while

        System.out.println("Your score " + GameLogic.getCurrentUser().getNickName() + " is :" + GameLogic.getCurrentUser().getScore());

        HandleFileInputOutput.writeScore(GameLogic.getCurrentUser());
        HandleFileInputOutput.viewLeaderboards();
    }
}

