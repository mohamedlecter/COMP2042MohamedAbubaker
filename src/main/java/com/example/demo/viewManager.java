package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.demo.modle.InfoLable;
import com.example.demo.modle.MenuSubScene;
import com.example.demo.modle.THEME;
import com.example.demo.modle.ThemePicker;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


import javafx.scene.paint.Color;
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

    private final String BUTTON_STYLE = "-fx-background-color: black; -fx-text-fill: white";
    private MenuSubScene creditsSubScene;
    private MenuSubScene helpSubScene;
    private MenuSubScene scoreSubScene;
    private MenuSubScene themeChooserSubScene;


    private  MenuSubScene sceneToHide;

    List<ThemePicker> themeList;
    private THEME chosenTheme;


    public viewManager (){
        mainPane = new AnchorPane();
        mainPane.setStyle("-fx-background-color: white;");
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createSubScenes();
        createBtns();
    }

    private void showSubScene(MenuSubScene subScene){
        if(sceneToHide !=null){
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }

    private void createSubScenes(){
        creditsSubScene = new MenuSubScene();
        mainPane.getChildren().add(creditsSubScene);

        helpSubScene = new MenuSubScene();
        mainPane.getChildren().add(helpSubScene);

        scoreSubScene = new MenuSubScene();
        mainPane.getChildren().add(scoreSubScene);

        createThemeSubScene();

    }

    private void createThemeSubScene(){
        themeChooserSubScene = new MenuSubScene();
        mainPane.getChildren().add(themeChooserSubScene);

        InfoLable chooseThemeLable = new InfoLable("CHOOSE YOUR THEME");
        chooseThemeLable.setLayoutX(110);
        chooseThemeLable.setLayoutY(25);

        themeChooserSubScene.getPane().getChildren().add(chooseThemeLable);
        themeChooserSubScene.getPane().getChildren().add(createThemes());
        themeChooserSubScene.getPane().getChildren().add(startBtn());

    }

    private HBox createThemes(){
        HBox box = new HBox();
        box.setSpacing(20);
        themeList = new ArrayList<>();
        for (THEME theme: THEME.values()){
            ThemePicker themeTopick = new ThemePicker(theme);
            themeList.add(themeTopick);
            box.getChildren().add(themeTopick);
            themeTopick.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for (ThemePicker them : themeList){
                        // if one of the themes is clicked, it will set to not chosen
                        them.setIsCircleChoosen(false);
                    }
                    // but theme to pick will be set to true
                    themeTopick.setIsCircleChoosen(true);
                    chosenTheme = themeTopick.getTheme();
                }
            });
        }
        box.setLayoutX(300 - (120 *2));
        box.setLayoutY(100);
        return box;
    }
    private Button startBtn(){
        Button button = new Button("START");
        button.setLayoutX(400);
        button.setLayoutY(350);
        button.setStyle(BUTTON_STYLE);
        button.setFont(Font.font("verdana", 23));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (chosenTheme != null){
                    GameViewManager gameManager = new GameViewManager();
                    gameManager.createNewGame(mainStage, chosenTheme);
                }
            }
        });
        return button;
    }

    public Stage getMainStage(){
        return mainStage;
    }

        private void setButtonPressedStyle(Button button) {
        String BUTTON_PRESSED_STYLE = "-fx-background-color: green;";
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

       button.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
              showSubScene(themeChooserSubScene);
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

}