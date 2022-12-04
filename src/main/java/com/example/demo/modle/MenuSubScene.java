package com.example.demo.modle;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * this class is for creating a new sub scene, it'll be used through out the MainMenuSubScene class whenever a new sub scene
 * is created
 */

public class MenuSubScene extends SubScene{
    private  boolean isHidden;
    public MenuSubScene() {
        super(new AnchorPane(), 600, 400);
        prefWidth(600);
        prefHeight(500);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(new BackgroundFill(Color.rgb(180, 80, 44, 0.7), null, null)));
        isHidden = true ;
        setLayoutX(1050);
        setLayoutY(200);

    }

    /**
     * this function transitions the sub scene using TranslateTransition() build in function, but first it checks the
     * variable hidden value, and based on it's value it either displays the sub scene or not
     */
    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);
        if (isHidden) {
            transition.setToX(-676);
            isHidden = false;

        } else {
            transition.setToX(0);
            isHidden = true ;
        }
        transition.play();
    }

    public AnchorPane getPane() {
        return (AnchorPane) this.getRoot();
    }

}