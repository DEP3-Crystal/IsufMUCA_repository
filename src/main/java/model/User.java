package main.java.model;

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

    public void printStatus() throws InterruptedException {
        switch (currentChances) {
            case 6:
                System.out.println("Excellent ! You are  completely safe, nothing is drawn yet.");
                break;
            case 5:
                System.out.println("The head is drawn.");
                break;
            case 4:
                System.out.println("The head and the body is drawn.");
                break;
            case 3:
                System.out.println("The head,body and the left arm is drawn.");
                break;
            case 2:
                System.out.println("The head,body, right arm and the left arm is drawn.");
                break;
            case 1:
                System.out.println("The head, body, right arm, left arm and right leg is drawn. Be careful my Guest !");
                break;
            case 0:
                System.out.println("You Lost !");
                Thread.sleep(3500);
                break;
        }
    }

}
