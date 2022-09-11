package main.java.oop;

import java.util.ArrayList;

public class SportiveGame extends Game {
    private final ArrayList<String> equipments;

    public SportiveGame(String name, ArrayList<String> rules, boolean playsInTeams, int numberOfPlayersPerTeam, ArrayList<String> equipments) {
        super(name, rules, playsInTeams, numberOfPlayersPerTeam);
        this.equipments = equipments;
    }

    @Override
    public void displayInfo() {

        super.displayInfo();

        //prints equipments
        System.out.println("\nEquipments :");
        int index = 1;
        for (String equipment : equipments) {
            System.out.println(index + ") " + equipment);
            index++;
        }
    }

    public void displayInfo(String specificInfo) {

        switch (specificInfo) {
            case "name":
                System.out.println("Name is: " + name);
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
                //prints equipments
                System.out.println("\nEquipments :");
                int index = 1;
                for (String equipment : equipments) {
                    System.out.println(index + ") " + equipment);
                    index++;
                }
                break;
            }
            default:
                System.out.println("Invalid input into method");
                break;

        }
        System.out.println("\n");
    }


}
