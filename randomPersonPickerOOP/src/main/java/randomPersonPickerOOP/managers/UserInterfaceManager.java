package com.randomPersonPickerOOP.managers;

import com.randomPersonPickerOOP.GroupFromFile;
import com.randomPersonPickerOOP.pojo.Person;

import java.util.Scanner;

public class UserInterfaceManager {
    GroupFromFile groupFromFile;
    private final static Scanner scan = new Scanner(System.in);

    private final RandomPersonManager randomPersonManager;

    public UserInterfaceManager(GroupFromFile groupFromFile) {
        this.groupFromFile = groupFromFile;
        randomPersonManager = new RandomPersonManager(groupFromFile);
    }

    private void printMenu() {
        System.out.println("Hi !!!  PLEASE pick one of the options below.");
        System.out.println("1.Print all persons.");
        System.out.println("2.Pick a person by random.");
        System.out.println("3.Print how many times is answered each person.");
        System.out.println("4.Print how many times is answered a person with the given email.");
        System.out.println("Any number to exit application");
        System.out.println("Answer: ");
    }

    private void pickOption() {

        try {
            int answerToMenu = scan.nextInt();

            switch (answerToMenu) {
                case 1:
                    groupFromFile.printPersons();
                    break;
                case 2:
                    while (true) {
                        if (groupFromFile.checkAvailableChances()) {
                            Person luckyPerson = randomPersonManager.getRandomPerson();
                            System.out.println("Picked person is: " + luckyPerson.getName() + " " + luckyPerson.getSurname());
                            System.out.println("You want to continue picking a random person ( yes/no )?");
                            String ans = scan.next();
                            if (ans.charAt(0) == 'n' || ans.charAt(0) == 'N')
                                break;
                        } else {
                            groupFromFile.fillChances();
                        }
                    }
                    break;

                case 3:
                    groupFromFile.printTimesActivated();
                    break;
                case 4:
                    System.out.println("Enter email of person: ");
                    String entryEmail = scan.nextLine().split(" ")[0];
                    boolean found = false;
                    for (Person person : groupFromFile.getPersons()) {
                        if (person.getEmail().equals(entryEmail)) {
                            groupFromFile.printTimesActivated(entryEmail);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("You entered an invalid email");
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception exception) {
            System.out.println("Enter a number please ! ! !");
        }

    }

    public void start() {
        while (true) {
            printMenu();
            pickOption();
            System.out.println("YOU WANT TO EXIT: \ny or Y for yes\nanything for no");
            String answer = scan.next();
            if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y')
                break;
        }
    }


}
