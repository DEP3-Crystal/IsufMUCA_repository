package com.randomPersonPickerWithPropability;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PickRandomPersonWithProbabilityAndMenu {
    static List<String> persons = List.of("isuf.muca@crystal-system.eu", "danjel.halili@crystal-system.eu", "flavio.lorenci@crystal-system.eu", "elia.omeri@crystal-system.eu", "ardit.elezi@crystal-system.eu", "luka.buziu@crystal-system.eu", "megi.lala@crystal-system.eu", "irena.shahini@crystal-system.eu", "indrit.vaka@crystal-system.eu", "griselda.muci@crystal-system.eu", "theodor.gheorghe@crystal-system.eu", "ioan.cocianu@crystal-system.eu", "teofil.mitrea@crystal-system.eu", "eduard.tiutiu@crystal-system.eu", "george.dobrota@crystal-system.eu", "stefanita.plesa@crystal-system.eu", "adrian-nicolae.tigau@crystal-system.eu", "emanuel.grabovschi@crystal-system.eu", "george.sirbu@crystal-system.eu", "andrei.state@crystal-system.eu", "florin-adrian.dumitru@crystal-system.eu", "victor.hincu@crystal-system.eu");
    static ArrayList<Integer> personChances = new ArrayList<>();
    static Random random = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void fillChances() {
        for (int i = 0; i < persons.size(); i++) {
            personChances.add(10);
        }
    }

    public static void decreaseChances(int index) {
        int temp = personChances.get(index);
        personChances.remove(index);
        personChances.add(index, temp - 1);
    }

    public static void pickRandom() {

        int index = random.nextInt(persons.size());
        while (true) {
            if (personChances.get(index) != 0) {
                System.out.println("Picked person is : " + persons.get(index));
                decreaseChances(index);
                break;
            }
        }
    }

    public static boolean checkAvailableChances() {
        int index;
        for (index = 0; index < personChances.size(); index++) {
            if (personChances.get(index) != 0)
                return true;
        }
        return false;
    }

    public static void printPersons() {
        int temp = 0;
        for (String person : persons) {
            System.out.print(person + '\t');
            temp++;
            if (temp % 3 == 0)
                System.out.print("\n\n");
        }
    }

    public static void printTimesAnswered() {
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i) + " is answered " + (10 - personChances.get(i)) + " time(s)");
        }
    }

    public static void printTimesAnswered(int index) {
        System.out.println(persons.get(index) + " is answered " + (10 - personChances.get(index)) + " time(s)");
    }

    public static void printMenu() {
        System.out.println("Hi !!!  PLEASE pick one of the options below.");
        System.out.println("1.Print all persons.");
        System.out.println("2.Pick a person by random.");
        System.out.println("3.Print how many times is answered each person.");
        System.out.println("4.Print how many times is answered a person at a specific index.");
        System.out.println("Everything else to exit application");
    }

    public static void pickOption() {
        int answerToMenu = scan.nextInt();

        switch (answerToMenu) {
            case 1:
                printPersons();
                break;
            case 2:
                while (true) {
                    if (checkAvailableChances()) {
                        pickRandom();
                        System.out.println("You want to continue picking a random person ?");
                        String ans = scan.next();
                        if (ans.charAt(0) == 'n' || ans.charAt(0) == 'N')
                            break;
                    } else {
                        fillChances();
                    }
                }
                break;
            case 3:
                printTimesAnswered();
                break;
            case 4:
                System.out.println("Enter index of person: ");
                int index = scan.nextInt();
                if (index < persons.size())
                    printTimesAnswered(index);
                else
                    System.out.println("You entered an invalid index");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {

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
