package com.example.demo.modle;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.nio.Buffer;

public class ThemePicker extends VBox {
    private final Button button;
    private ImageView circleImage;
    private ImageView themeImage;

    private String circleNotChoosen = "https://raw.githubusercontent.com/smowgli/space-runner-game-javafx/dcbb51c278680951043d41d520e1a093f55701dc/src/resources/grey_circle.png";
    private String circleChoosen = "https://raw.githubusercontent.com/smowgli/space-runner-game-javafx/dcbb51c278680951043d41d520e1a093f55701dc/src/resources/red_choosen.png";

    private THEME theme;

    private boolean isCircleChoosen;


    public ThemePicker(Button button) {
        circleImage = new ImageView(circleNotChoosen);
//        themeImage = new ImageView(theme.getUrl());
        this.button = button;
        isCircleChoosen = false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.getChildren().add(circleImage);
//        this.getChildren().add(themeImage);

    }

    public THEME getTheme() {
        return theme;
    }

    public boolean getCircleChoosen() {
        return isCircleChoosen;
    }

    public void setIsCircleChoosen(boolean isCircleChoosen) {
        this.isCircleChoosen = isCircleChoosen;
        String imageToSet = this.isCircleChoosen ? circleChoosen : circleNotChoosen;
        circleImage.setImage(new Image(imageToSet));
    }
}
