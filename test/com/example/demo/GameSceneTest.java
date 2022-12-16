package com.example.demo;

import static com.example.demo.GameScene.elapsedTime;
import static com.example.demo.GameScene.timer;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameSceneTest {
    @org.junit.jupiter.api.Test
    void testTimer() {
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

}