package com.ai;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


class GameLogicTest {

    GameLogic logic = new GameLogic();

    @Test
    void popRandomWord() {

        ArrayList<String> list = new ArrayList<>();

        ArrayList<String> temp = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            list.add("alfa");
            list.add("beta");
            list.add("gama");

            temp.add("alfa");
            temp.add("beta");
            temp.add("gama");

        }

        String guess = logic.popRandomWord(list);

        Assertions.assertEquals(2, list.size(), list.size() - 2);

        Assertions.assertTrue(temp.contains(guess));

    }

    @Test
    void buildWord() {

        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(0, "g");
        myMap.put(1, "u");
        myMap.put(2, "i");

        Assertions.assertEquals("gui", logic.buildWord(myMap));

    }

    @Test
    void checkCorrectGuess() {

      Assertions.assertTrue(logic.checkCorrectGuess("l","look"));

    }

    @Test
    void initializeMap() {

        String word= "alfa";

        Map<Integer, String> myMap = new HashMap<>();

        logic.initializeMap(word,myMap);

        Assertions.assertEquals("____", logic.buildWord(myMap));


    }

    @Test
    void wordIsComplete() {

        Map<Integer, String> myCompletedMap = new HashMap<>();

        Map<Integer, String> myNotCompletedMap = new HashMap<>();

        myCompletedMap.put(0, "g");
        myCompletedMap.put(1, "u");
        myCompletedMap.put(2, "i");

        myNotCompletedMap.put(0, "g");
        myNotCompletedMap.put(1, "u");

       Assertions.assertTrue(logic.wordIsComplete("gui",myCompletedMap));

       Assertions.assertFalse(logic.wordIsComplete("gui",myNotCompletedMap));

    }

}