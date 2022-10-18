package com.models;

import java.io.Serializable;

public class LeaderboardRecord implements Serializable {
    private String nickName;
    private int score;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LeaderboardRecord(String nickName, int score) {
        this.nickName = nickName;
        this.score = score;
    }
}
