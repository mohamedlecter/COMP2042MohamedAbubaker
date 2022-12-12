package com.example.demo;

import org.testng.annotations.Test;

import static com.example.demo.GameScene.elapsedTime;
import static com.example.demo.GameScene.timer;
import static org.junit.jupiter.api.Assertions.*;

class GameSceneTest {
//    @Test
//     void testTimer() {
//        // Start the timer
//        timer.start();
//        // Wait for 1 second
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Stop the timer
//        timer.stop();
//
//        // Assert that the elapsed time is 1 second
//        assertEquals(1000, elapsedTime);
//    }

    @org.junit.jupiter.api.Test
    void game() {
        timer.start();
        // Wait for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Stop the timer
        timer.stop();

        // Assert that the elapsed time is 1 second
        assertEquals(1000, elapsedTime);
    }

    @org.junit.jupiter.api.Test
    void helpScreen() {
    }

    @org.junit.jupiter.api.Test
    void exitScreen() {
    }

    @org.junit.jupiter.api.Test
    void settingsScreen() {
    }
}