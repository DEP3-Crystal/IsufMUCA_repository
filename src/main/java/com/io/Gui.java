package com.io;

import com.models.LeaderboardRecord;
import com.models.User;

import java.util.*;

public class Gui {
    private Scanner input = new Scanner(System.in);

    public User promptUserData() {

        String nickName, desc;
        int age;

        System.out.print("Hi !\nWhat is your nickname: ");

        nickName = input.nextLine().trim();

        System.out.println("Can you please share a short description of yours with us ?!");

        desc = input.nextLine().trim();

        System.out.println("\nHow old are you sir: ");

        age = Integer.parseInt(input.nextLine().trim());

        return new User(nickName, age, desc);
    }

    public void displayGuessResult(ArrayList<String> wrongGuesses) {

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

    public void displayWord(Map<Integer, String> mappedLetters, String word) {

        if (word != null) {
            System.out.println("Your Word is: ");

            for (int i = 0; i < word.length(); i++) {
                System.out.print(mappedLetters.get(i) + " ");

            }
            System.out.println("\n");
        }
    }

    public String promptInputForLetter() {

        System.out.print("\nGuess a new letter : ");

        String letter = input.nextLine();

        while (letter.length() != 1) {

            System.out.println("Enter a letter please not a word or blank space : ");

            letter = input.nextLine();
        }

        return letter.toUpperCase();
    }

    public void leaderboards(ArrayList<LeaderboardRecord> records) {

        System.out.println("Do you want to see the leaderboards ?");

        System.out.println("Answer: ");

        String answer = input.next();

        if (answer.trim().charAt(0) == 'Y' || answer.trim().charAt(0) == 'y') {

            System.out.println("---------------- LEADERBOARDS ----------------\n\n");

            records.sort(Comparator.comparingInt(LeaderboardRecord::getScore));

            int index = 1;

            for (LeaderboardRecord record : records) {
                System.out.println(index + "." + record.getNickName() + " ==> " + record.getScore() + " points");
                index++;
            }
        }
    }

    public void congratsForRightLetterGuess() {
        System.out.println("Congrats, you found one letter !!!");
    }

    public void congratsForFindingWord() {
        System.out.println("\"Congrats, you found one word !!!\"");
    }

    public void notifyWrongGuess() {
        System.out.println("WRONG !!!");
    }

}
