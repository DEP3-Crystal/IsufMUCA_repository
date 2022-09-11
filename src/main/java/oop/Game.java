package main.java.oop;

import java.util.ArrayList;

public class Game {

    String name;
    protected ArrayList<String> rules;
    protected boolean playsInTeams;
    protected int numberOfPlayersPerTeam;

    public Game(String name, ArrayList<String> rules, boolean playsInTeams, int numberOfPlayersPerTeam) {
        this.name = name;
        this.rules = rules;
        this.playsInTeams = playsInTeams;
        this.numberOfPlayersPerTeam = numberOfPlayersPerTeam;
    }

    public void displayInfo() {

        System.out.println("Game is called: " + name);
        System.out.println(playsInTeams ? "It plays in teams" : "It does not plays in teams");
        System.out.println(playsInTeams ? "Number of players per team: " + numberOfPlayersPerTeam : "Number of players: " + numberOfPlayersPerTeam);
        System.out.println("\nRules :");

        //prints rules
        int index = 1;
        for (String rule : rules) {
            System.out.println(index + ") " + rule);
            index++;
        }
        System.out.println();
    }

}
