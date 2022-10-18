package com.models;

public class User {
    String nickName;
    int age;
    String description;
    int score;
    int currentChances;

    public User(String nickName, int age, String description) {

        this.nickName = nickName;
        this.age = age;
        this.description = description;
        currentChances = 6;
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNickName() {
        return nickName;
    }

    public int getCurrentChances() {
        return currentChances;
    }

    public void lowerCurrentChances() {
        currentChances--;
    }

    public String printStatus() {

        String status = null;

        switch (currentChances) {
            case 6:
                status = "Excellent ! You are  completely safe, nothing is drawn yet.";
                break;
            case 5:
                status = "The head is drawn.";
                break;
            case 4:
                status = "The head and the body is drawn.";
                break;
            case 3:
                status = "The head,body and the left arm is drawn.";
                break;
            case 2:
                status = "The head,body, right arm and the left arm is drawn.";
                break;
            case 1:
                status = "The head, body, right arm, left arm and right leg is drawn. Be careful my Guest !";
                break;
            case 0:
                status = "You Lost !";
                break;
        }
        return status;
    }

}
