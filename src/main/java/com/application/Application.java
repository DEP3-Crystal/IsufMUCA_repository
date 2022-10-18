package com.application;

import com.ai.GameLogic;
import com.dao.DataFromLeaderboards;
import com.dao.DataFromWords;
import com.io.Gui;
import com.models.LeaderboardRecord;
import com.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {


        try {

            GameLogic logic = new GameLogic();

            Gui gui = new Gui();

            DataFromWords wordsDataStream = new DataFromWords();

            DataFromLeaderboards leaderboardsDataStream = new DataFromLeaderboards();

            User user = gui.promptUserData();

            ArrayList<String> words = wordsDataStream.readAllWords();

            ArrayList<String> wrongGuesses = new ArrayList<>();

            Map<Integer, String> mappedLetters = new HashMap<>();

            while (user.getCurrentChances() > 0) {

                String wordToBeFound = logic.popRandomWord(words);

                //Debugging
                System.out.println(wordToBeFound);

                logic.initializeMap(wordToBeFound, mappedLetters);

                while (!logic.wordIsComplete(wordToBeFound, mappedLetters)) {

                    gui.displayWord(mappedLetters, wordToBeFound);

                    String letter = gui.promptInputForLetter();

                    if (!logic.checkCorrectGuess(letter, wordToBeFound)) {

                        gui.notifyWrongGuess();

                        wrongGuesses.add(letter);

                        user.lowerCurrentChances();

                    } else {

                        gui.congratsForRightLetterGuess();

                        for (int i = 0; i < wordToBeFound.length(); i++) {
                            mappedLetters.put(wordToBeFound.indexOf(letter, i), letter);
                        }
                    }

                    gui.displayGuessResult(wrongGuesses);

                    gui.displayWord(mappedLetters, wordToBeFound);

                }// end while loop
                gui.congratsForFindingWord();
            }// end while loop

            leaderboardsDataStream.writeRecord(new LeaderboardRecord(user.getNickName(), user.getScore()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
