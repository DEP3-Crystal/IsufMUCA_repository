package main.java.oop;

import java.util.ArrayList;

public class VideoGame extends Game {

    private final boolean multiplayer;
    private final ArrayList<String> platforms;

    public VideoGame(String name, ArrayList<String> rules, boolean playsInTeams, int numberOfPlayersPerTeam, boolean multiplayer, ArrayList<String> platforms) {
        super(name, rules, playsInTeams, numberOfPlayersPerTeam);
        this.multiplayer = multiplayer;
        this.platforms = platforms;
    }

    @Override
    public void displayInfo() {

        System.out.println("Game is called: " + name);
        System.out.println(multiplayer ? "It is a multiplayer game" : "It is not a multiplayer game");
        System.out.println(playsInTeams ? "It plays in teams" : "It does not plays in teams");
        System.out.println(playsInTeams ? "Number of players per team: " + numberOfPlayersPerTeam : "Number of players: " + numberOfPlayersPerTeam);
        System.out.println("\nRules :");

        //prints rules
        int index = 1;
        for (String rule : rules) {
            System.out.println(index + ") " + rule);
            index++;
        }

        //prints platforms
        System.out.println("\nAvailable platforms :");
        index = 1;
        for (String platform : platforms) {
            System.out.println(index + ") " + platform);
            index++;
        }

    }

    public void displayInfo(String specificInfo) {

        switch (specificInfo) {
            case "name":
                System.out.println("Name is: " + name);
                break;
            case "multiplayer":
                System.out.println(multiplayer ? "It is a multiplayer game" : "It is not a multiplayer game");
                break;
            case "teams":
                System.out.println(playsInTeams ? "It plays in teams" : "It does not plays in teams");
                break;
            case "rules": {
                System.out.println("\nRules :");
                //prints rules
                int index = 1;
                for (String rule : rules) {
                    System.out.println(index + ") " + rule);
                    index++;
                }
                break;
            }
            case "platforms": {
                //prints platforms
                System.out.println("\nAvailable platforms :");
                int index = 1;
                for (String platform : platforms) {
                    System.out.println(index + ") " + platform);
                    index++;
                }

                break;
            }
        }
        System.out.println("\n");
    }
}
