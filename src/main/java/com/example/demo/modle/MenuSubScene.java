package com.example.demo.modle;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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