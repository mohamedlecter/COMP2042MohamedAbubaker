package com.example.demo;

import com.example.demo.modle.MenuSubScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.demo.MainMenuSubScence.*;

public class MainMenu {
    private static final int HEIGHT = 784;
    private static final int WIDTH = 1024;
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private final static int MENU_BUTTON_START_X = 100;
    private final static int MENU_BUTTON_START_Y = 150;
    private final String BUTTON_STYLE = "-fx-background-color: black; -fx-text-fill: white";
    private  MenuSubScene sceneToHide;


    public MainMenu (){
        mainPane = new AnchorPane();
        mainPane.setStyle("-fx-background-color: white;");
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        MainMenuSubScence.createSubScenes(mainPane, mainStage);
        createBtns();
    }
    public Stage getMainStage(){
        return mainStage;
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
        Button button = new Button("START NEW GAME");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y);
        button.setPrefWidth(250);
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

       button.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
              showSubScene(createStartGameSubScene);
           }
       });
        mainPane.getChildren().add(button);
    }

   
    private void createScoreButton(){
        Button button = new Button("SCORE");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 100);
        button.setPrefWidth(250);
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
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
              showSubScene(scoreSubScene);
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createHelpButton(){
        Button button = new Button("HELP");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 200);
        button.setPrefWidth(250);
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

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               showSubScene(helpSubScene);
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createCreditsButton(){
        Button button = new Button("CREDITS");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 300);
        button.setPrefWidth(250);
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

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(creditsSubScene);
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createExitButton(){
        Button button = new Button("EXIT");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 400);
        button.setPrefWidth(250);
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
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
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
    private void showSubScene(MenuSubScene subScene){
        if(sceneToHide !=null){
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }
    private void setButtonPressedStyle(Button button) {
        String BUTTON_PRESSED_STYLE = "-fx-background-color: green;";
        button.setStyle(BUTTON_PRESSED_STYLE);
        button.setPrefHeight(45);
    }

    private void setButtonReleasedStyle(Button button) {
        button.setStyle(BUTTON_STYLE);
        button.setPrefHeight(45);
    }
}