package com.example.demo;

/**
 * this class is used to set and get the score and name of the user in a text file
 * @author mohamed abubaker
 */
public class ScoreLeaderBoard implements Comparable {
    String name;
    int score;

    /**
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name sets the name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @param score sets the score
     */
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        return ((ScoreLeaderBoard) o).score - this.score;
    }
}


