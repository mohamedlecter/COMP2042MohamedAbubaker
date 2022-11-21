package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;


import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class viewManager {
    private static final int HEIGHT = 784;
    private static final int WIDTH = 1024;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int MENU_BUTTON_START_X = 100;
    private final static int MENU_BUTTON_START_Y = 150;

    private final String BUTTON_STYLE = "-fx-background-color: blue; -fx-background-image: url('src/main/java/com/example/demo/resources/red_button.png');";

    List<Button> menuButtons;
    public viewManager (){
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createBtns();
    }

    public Stage getMainStage(){
        return mainStage;
    }

    private void addMenuButtons(Button button){
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 5 * 100);
        button.setPrefWidth(150);
        button.setPrefHeight(49);
        button.setStyle(BUTTON_STYLE);
        button.setFont(Font.font("verdana", 23));
        mainPane.getChildren().add(button);
    }
        private void setButtonPressedStyle(Button button) {
        String BUTTON_PRESSED_STYLE = "-fx-background-color: red; -fx-background-image: url('/resources/red_button_pressed.png');";
        button.setStyle(BUTTON_PRESSED_STYLE);
        button.setPrefHeight(45);
//        button.setLayoutY(button.getLayoutY() + 4);
    }

    private void setButtonReleasedStyle(Button button) {
        button.setStyle(BUTTON_STYLE);
        button.setPrefHeight(45);
//        button.setLayoutY(button.getLayoutY() + 4);
    }

    public void createBtns (){
        createStartButton();
        createScoreButton();
        createHelpButton();
        createCreditsButton();
        createExitButton();
        createLogo();
    }

    private void createStartButton(){
        Button button = new Button("START");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y);
        button.setPrefWidth(150);
        button.setPrefHeight(49);
        button.setStyle(BUTTON_STYLE);
        button.setFont(Font.font("verdana", 23));
                button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle(button);
                }
            }
        });

       button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleasedStyle(button);
                }
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createScoreButton(){
        Button button = new Button("SCORE");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 100);
        button.setPrefWidth(150);
        button.setPrefHeight(49);
        button.setStyle(BUTTON_STYLE);
        button.setFont(Font.font("verdana", 23));
        button.setFont(Font.font("verdana", 23));
        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle(button);
                }
            }
        });

        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleasedStyle(button);
                }
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createHelpButton(){
        Button button = new Button("HELP");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 200);
        button.setPrefWidth(150);
        button.setPrefHeight(49);
        button.setStyle(BUTTON_STYLE);
        button.setFont(Font.font("verdana", 23));
        button.setFont(Font.font("verdana", 23));
        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle(button);
                }
            }
        });

        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleasedStyle(button);
                }
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createCreditsButton(){
        Button button = new Button("CREDITS");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 300);
        button.setPrefWidth(150);
        button.setPrefHeight(49);
        button.setStyle(BUTTON_STYLE);
        button.setFont(Font.font("verdana", 23));
        button.setFont(Font.font("verdana", 23));
        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle(button);
                }
            }
        });

        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleasedStyle(button);
                }
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createExitButton(){
        Button button = new Button("EXIT");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 400);
        button.setPrefWidth(150);
        button.setPrefHeight(49);
        button.setStyle(BUTTON_STYLE);
        button.setFont(Font.font("verdana", 23));
        button.setFont(Font.font("verdana", 23));
        button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressedStyle(button);
                }
            }
        });

        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleasedStyle(button);
                }
            }
        });
        mainPane.getChildren().add(button);
    }

    private void createLogo(){
        Text logo = new Text("2048");
        logo.setFont(Font.font(35));
        logo.setLayoutX(600);
        logo.setLayoutY(50);

        mainPane.getChildren().add(logo);
    }

}