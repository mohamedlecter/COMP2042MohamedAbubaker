package com.example.demo.modle;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

public class InfoLable extends Label {
    // change the url
    public final static String BACKGROUND_IMAGE = "https://raw.githubusercontent.com/smowgli/space-runner-game-javafx/dcbb51c278680951043d41d520e1a093f55701dc/src/resources/red_small_panel.png";
    public InfoLable(String text){
        prefWidth(380);
        prefHeight(49);
        setPadding(new Insets(10, 40, 10, 40));
        setText(text);
        setWrapText(true);
        setFont(Font.font( "verdana",20));
        setAlignment(Pos.CENTER);

//
//        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 380, 49, false, true), BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
//        setBackground(new Background(backgroundImage));
    }

    public void ScoreInfoLable (String text){
        prefWidth(130);
        prefHeight(50);
        setPadding(new Insets(10, 10, 10, 10));
        setText(text);
        setWrapText(true);
        setFont(Font.font( "verdana",20));
        setAlignment(Pos.CENTER_LEFT);


        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 380, 49, false, true), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));

    }
}