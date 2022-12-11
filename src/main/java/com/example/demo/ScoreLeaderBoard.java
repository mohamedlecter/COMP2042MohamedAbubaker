package com.example.demo;

/**
 * this class is used to set and get the score and name of the user in a text file
 */

public class ScoreLeaderBoard implements Comparable {
    String name;
    int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        return ((ScoreLeaderBoard) o).score - this.score;
    }
}


