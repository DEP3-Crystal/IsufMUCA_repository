package main.java.oop;

import java.util.ArrayList;

public class CompileTimeRuntimePolymorphism {
    public static void main(String[] args) {


        /*
        Reference variables have 2 hidden pointers within them:

        1) A pointer to a table which contains the names of the methods specific for that object

        2) A pointer to the memory allocated on the heap for that object’s data (values of instance variables)
         */

        //data for the football game
        ArrayList<String> footballRules = new ArrayList<>();
        footballRules.add("A goal is scored when the ball enters into gate");
        footballRules.add("Only the goalkeeper can touch the ball by hand, only inside his zone");
        footballRules.add("You get punished for offensive acts");
        footballRules.add("Game consists of two parts with 45 min,90 min total");
        footballRules.add("A lot more !");

        ArrayList<String> footballEquipments = new ArrayList<>();
        footballEquipments.add("ball");

        //data for Tetris videogame
        ArrayList<String> tetrisRules = new ArrayList<>();
        tetrisRules.add("Player must redirect blocks in that way that the floor is completed");
        tetrisRules.add("You lose if your screen is full of blocks");
        tetrisRules.add("Play to beat other players high scores");

        ArrayList<String> tetrisPlatforms = new ArrayList<>();
        tetrisPlatforms.add("Microsoft Windows");


        Game football = new SportiveGame("football", footballRules, true, 11, footballEquipments);

        football.displayInfo();
        //override method --> runtime polymorphism
        // football.displayInfo("rules"); --> can't use here because method is not declared in Game class

        SportiveGame sport = (SportiveGame) football;
        sport.displayInfo();
        sport.displayInfo("rules");


        Game tetris = new VideoGame("tetris",tetrisRules,false,1,false,tetrisPlatforms);
        tetris.displayInfo();
        // tetris.displayInfo("platforms"); --> can't use here because method is not declared in Game class

        VideoGame tetrisVideoGame = new VideoGame("tetris",tetrisRules,false,1,false,tetrisPlatforms);
        tetrisVideoGame.displayInfo();
        tetrisVideoGame.displayInfo("platforms");
    }
}
