package com.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.models.LeaderboardRecord;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

public class DataFromLeaderboards {

    private final ObjectMapper mapper = new ObjectMapper();

    private final File leaderboardsFile = new File("src/main/resources/leaderboards.json");

    public DataFromLeaderboards() {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public ArrayList<LeaderboardRecord> readAllLeaderboards() throws IOException {

        ArrayList<LeaderboardRecord> allRecords = new ArrayList<>();

        JsonNode arrayNode = mapper.readTree(leaderboardsFile);

        for (JsonNode node : arrayNode) {
            allRecords.add(new LeaderboardRecord(node.get("nickName").asText(), node.get("score").asInt()));
        }

        return allRecords;
    }

    public void writeRecord(LeaderboardRecord record) throws IOException {
        mapper.writeValue(leaderboardsFile, record);
    }

    public void writeRecords(ArrayList<LeaderboardRecord> records) throws IOException {
        for (LeaderboardRecord record : records) {
            mapper.writeValue(leaderboardsFile, record);
        }
    }


}
