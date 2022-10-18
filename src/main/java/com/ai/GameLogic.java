package com.ai;

import java.util.*;

public class GameLogic {
    private final Scanner input = new Scanner(System.in);
    private final Random rand = new Random();

    public String popRandomWord(ArrayList<String> words) {
        if (words.size() > 0) {

            int randomPickedIndex = rand.nextInt(words.size());
            String word = words.get(randomPickedIndex);
            words.remove(randomPickedIndex);
            return word;
        }
        return null;
    }

    public String buildWord(Map<Integer, String> mappedLetters) {

        StringBuilder word = new StringBuilder();

        if (!mappedLetters.isEmpty()) {

            for (int i = 0; i < mappedLetters.size(); i++) {
                word.append(mappedLetters.get(i));
            }

            return word.toString();
        }

        return null;
    }

    public boolean checkCorrectGuess(String guessedLetter, String word) {
        if (word != null) {
            return word.contains(guessedLetter);
        }

        return false;
    }

    public void initializeMap(String word, Map<Integer, String> mappedLetters) {

        if (word != null) {

            for (int i = 0; i < word.length(); i++) {

                mappedLetters.put(i, "_");
            }
        }
    }

    public boolean wordIsComplete(String word, Map<Integer, String> mappedLetters) {

        if (word != null) {
            StringBuilder temp = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                temp.append(mappedLetters.get(i));
            }

            return temp.toString().equals(word);
        }
        return false;
    }


}
