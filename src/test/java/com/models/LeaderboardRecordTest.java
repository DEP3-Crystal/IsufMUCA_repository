package com.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardRecordTest {

   LeaderboardRecord leaderboardRecord =new LeaderboardRecord("nickName",100);

    @Test
    void nickName() {

        Assertions.assertEquals("nickName",leaderboardRecord.getNickName());

        leaderboardRecord.setNickName("newNickName");

        Assertions.assertEquals("newNickName",leaderboardRecord.getNickName());
    }

    @Test
    void score() {

        Assertions.assertEquals(100,leaderboardRecord.getScore());

        leaderboardRecord.setScore(222);

        Assertions.assertEquals(222,leaderboardRecord.getScore());

    }


}