package com.example;

public class Record {
    private String playerName;
    private int playerScore;

    public Record(String name, int score) {
        this.playerName = name;
        this.playerScore = score;
    }

    public String getName() {
        return this.playerName;
    } 

    public int getScore() {
        return this.playerScore;
    } 

    public String toString() {
        return "Player Name: " + this.playerName + " | Score: " + this.playerScore;
    }

}
