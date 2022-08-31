package main.java.ai;

import main.java.io.HandleFileInputOutput;
import main.java.model.User;

import java.util.*;

public class GameLogic {
    private static final Scanner input = new Scanner(System.in);
    private static final Random rand = new Random();
    private static final ArrayList<String> words = new ArrayList<>();
    private static String currentWord;
    private static String wordInProgress;
    private static Map<Integer, String> mappedLetters;
    private static ArrayList<String> wrongGuesses = new ArrayList<>();
    private static User currentUser;

    public static void promptUserData() {
        System.out.print("Hi !\nWhat is your nickname: ");
        String nickName = input.nextLine();
        System.out.println("Can you please share a short description of yours with us ?!");
        String desc = input.nextLine();
        System.out.println("\nHow old are you sir: ");
        int age = Integer.parseInt(input.nextLine());

        currentUser = new User(nickName, age, desc);
        HandleFileInputOutput.loadResources();
    }

    public static void pickRandomWord() {

        int randomPickedIndex = rand.nextInt(words.size());
        currentWord = words.get(randomPickedIndex);
        words.remove(randomPickedIndex);
    }

    public static void showWrongGuesses() {
        if (wrongGuesses.size() > 0) {
            System.out.print("\nLetters that you guessed wrong: ");
            for (String letter : wrongGuesses) {
                System.out.print(letter + " ");
            }
            System.out.println();
        } else {
            System.out.println("No wrong guesses ! Everything all right !");
        }
    }

    public static void buildWord() {
        wordInProgress = "";
        for (int i = 0; i < currentWord.length(); i++) {
            wordInProgress = wordInProgress.concat(mappedLetters.get(i) + " ");
        }
    }

    public static void displayCurrentWorldInfo() {
        System.out.println("Your word :\n" + wordInProgress);
    }

    public static void checkCorrect(String guessedLetter) {
        if (currentWord.contains(guessedLetter)) {
            for (int i = 0; i < currentWord.length(); i++) {
                mappedLetters.put(currentWord.indexOf(guessedLetter, i), guessedLetter);
            }
            buildWord();
        } else {
            if (!wrongGuesses.contains(guessedLetter)) {
                wrongGuesses.add(guessedLetter);
            }
            currentUser.lowerCurrentChances();
        }
    }

    public static String promptInput() {
        System.out.print("\nGuess a new letter : ");
        String letter = input.nextLine();

        while (letter.length() != 1) {
            System.out.println("Enter a letter please not a word : ");
            letter = input.nextLine();
        }
        return letter.toUpperCase();
    }

    public static void initMap() {
        mappedLetters = new HashMap<>();
        for (int i = 0; i < currentWord.length(); i++) {
            mappedLetters.put(i, "_");
        }
    }

    public static boolean wordIsComplete() {
        String temp = "";
        for (int i = 0; i < currentWord.length(); i++) {
            temp = temp.concat(mappedLetters.get(i));
        }
        return currentWord.equals(temp);
    }

    public static ArrayList<String> getWords() {
        return words;
    }

    public static int getWordCount() {
        return words.size();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void clearCashed() {
        wrongGuesses = new ArrayList<>();
    }

    public static void increaseUserScores() {
        currentUser.setScore(currentUser.getScore() + 10);
    }
}
