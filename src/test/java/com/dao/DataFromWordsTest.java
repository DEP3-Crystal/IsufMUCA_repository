package com.dao;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DataFromWordsTest {

    DataFromWords dataFromWords = new DataFromWords();

    @org.junit.jupiter.api.Test
    void readAllWords() throws IOException {

        ArrayList<String> words = dataFromWords.readAllWords();

        ArrayList<String> actualWords = new ArrayList<>();

        actualWords.addAll(List.of("HAMMER",
                "HELICOPTER",
                "VEHICLE",
                "WARRIOR",
                "PROGRAMMER",
                "OCTOPUS",
                "PREMIUM",
                "MAGICIAN",
                "GIRAFFE",
                "ANTARCTICA",
                "ALGORITHM",
                "HERO",
                "VILLAIN",
                "JOKE",
                "TOP",
                "COW",
                "CAT",
                "DOG",
                "BEE",
                "BETTER"));

        System.out.println(words);

        System.out.println(actualWords);

        Assertions.assertTrue((words.size() == actualWords.size()) && words.containsAll(actualWords));




    }
}