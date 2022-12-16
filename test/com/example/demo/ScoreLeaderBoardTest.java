package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreLeaderBoardTest {
   private ScoreLeaderBoard scoreLeaderBoard = new ScoreLeaderBoard();
    @Test
    public void testSetAndGetUsername() {
        // setting the username
        String username = "mohamed";
        scoreLeaderBoard.setName(username);

        // We verify that the getName method returns the correct name
        assertEquals(username, scoreLeaderBoard.getName());
    }

    @Test
    public void testSetAndGetScore() {
        // setting the score
        int time = 10000;
        scoreLeaderBoard.setTime(time);

        // We verify that the getScore method returns the correct score
        assertEquals(time, scoreLeaderBoard.getTime());
    }

    @Test
    public void testSetAndGetTime() {
        // setting the time
        int time = 50;
        scoreLeaderBoard.setScore(time);

        // We verify that the getTime method returns the correct time
        assertEquals(time, scoreLeaderBoard.getScore());
    }
}