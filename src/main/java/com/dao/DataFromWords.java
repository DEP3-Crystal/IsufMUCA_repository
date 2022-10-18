package com.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataFromWords {

    File wordsFile = new File("src/main/resources/words.json");

    ObjectMapper mapper = new ObjectMapper();

    public DataFromWords() {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public ArrayList<String> readAllWords() throws IOException {

        ArrayList<String> words = new ArrayList<>();

        JsonNode arrayNode = mapper.readTree(wordsFile).findValue("words");

        for (JsonNode word : arrayNode) {
            words.add(word.asText());
        }

        return words;
    }




}
