package com.example.demo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.demo.modle.InfoLable;
import com.example.demo.modle.MenuSubScene;
import com.example.demo.modle.THEME;
import com.example.demo.modle.ThemePicker;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private MenuSubScene createStartGameSubScene;
    private MenuSubScene createContinueSubScene;
    private MenuSubScene creditsSubScene;
    private MenuSubScene helpSubScene;
    private MenuSubScene scoreSubScene;
    private  MenuSubScene sceneToHide;
    List<ThemePicker> themeList;
    private THEME chosenTheme;
    private String userName;

    File file = new File("D:\\Uni\\Y2\\Software Maintenance\\src\\main\\java\\com\\example\\demo\\data.txt");


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
        scoreSubScene = new MenuSubScene();
        mainPane.getChildren().add(scoreSubScene);

        createContinueSubScene = new MenuSubScene();
        mainPane.getChildren().add(createContinueSubScene);
//        createAccountSubScene();
        createStartGameSubScene();
        createHelpSubScene();
        createCreditsSubScene();

    }

    private void createStartGameSubScene(){
        createStartGameSubScene = new MenuSubScene();
        mainPane.getChildren().add(createStartGameSubScene);

        InfoLable helpLabel = new InfoLable("LOGIN");
        helpLabel.setLayoutX(120);
        helpLabel.setLayoutY(20);

        //Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setLayoutX(150);
        grid.setLayoutY(80);

        //Defining the Name text field
        final TextField name = new TextField();
        name.setPromptText("Enter your user name");
        name.setPrefColumnCount(10);
        name.getText();
        GridPane.setConstraints(name, 0, 0);
        grid.getChildren().add(name);

        //Defining the Submit button
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 1, 0);
        //Defining the Clear button
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);

        //Adding a Label
        final Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);

//        Setting an action for the Submit button
            submit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    System.out.println("user name: " + name.getText());
                    try{
                        if(!file.exists()){
                            System.out.println("File was not found, a new file file was created");
                            file.createNewFile();
                        }
                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write( name.getText() + "\n");
                        bufferedWriter.close();
                    }
                    catch (Exception error){
                        System.out.println(error);
                    }
                Account.makeNewAccount(userName);

            }
        });
        grid.getChildren().add(submit);

        //Setting an action for the Clear button
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                name.clear();
                label.setText(null);
            }
        });
        grid.getChildren().add(clear);
        createStartGameSubScene.getPane().getChildren().addAll(helpLabel,grid);
        createStartGameSubScene.getPane().getChildren().add(startBtn());

    }

    private void createHelpSubScene(){
        helpSubScene = new MenuSubScene();
        mainPane.getChildren().add(helpSubScene);

        InfoLable helpLabel = new InfoLable("HELP");
        helpLabel.setLayoutX(120);
        helpLabel.setLayoutY(20);

        Label text = new Label("Basically, 2048 presents with with a 4×4 grid. When you start the game, there will be two “tiles” on the grid, each displaying the number 2 or 4. You hit the arrow keys on your keyboard to move the tiles around — and also to generate new tiles, which will also be valued at 2 or 4. When two equal tiles collide, they combine to give you one greater tile that displays their sum. The more you do this, obviously, the higher the tiles get and the more crowded the board becomes. Your objective is to reach 2048 before the board fills up.");
        text.setFont(Font.font(20));
        text.setLayoutX(50);
        text.setLayoutY(80);
        text.setMaxWidth(500);
        text.setMaxHeight(450);
        text.setWrapText(true);
        text.setAlignment(Pos.CENTER);

        helpSubScene.getPane().getChildren().addAll(helpLabel, text);

    }

    private void createCreditsSubScene(){
        creditsSubScene = new MenuSubScene();
        mainPane.getChildren().add(creditsSubScene);

        InfoLable creditsLabel = new InfoLable("Credits ");
        creditsLabel.setLayoutX(120);
        creditsLabel.setLayoutY(20);

        Label credit0 = new Label("Programmed by Mohamed Abubaker Mohamed Ahmed - 20302059.");
        Label credit1 = new Label("Sounds and images from ");

        credit0.setFont(Font.font(20));
        credit0.setMaxWidth(500);
        credit0.setMaxHeight(450);
        credit0.setWrapText(true);
        credit0.setAlignment(Pos.CENTER);

        credit1.setFont(Font.font(20));
        credit1.setMaxWidth(500);
        credit1.setMaxHeight(450);
        credit1.setWrapText(true);
        credit1.setAlignment(Pos.CENTER);

        String[]link    = new String[6];
        link[0] = "https://github.com/mohamedlecter/COMP2042MohamedAbubaker";
        link[1] = "https://freesound.org/";

        Hyperlink link0, link1;
        link0 = new Hyperlink(link[0]);
        link1 = new Hyperlink(link[1]);

        VBox creditsBox = new VBox(10, credit0,link0, credit1, link1);

        creditsBox.setLayoutX(50);
        creditsBox.setLayoutY(80);
        creditsSubScene.getPane().getChildren().addAll(creditsLabel, creditsBox);

        Application app = new Application() {@Override public void start(Stage primaryStage) throws Exception{}};
        HostServices services = app.getHostServices();

        link0.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                services.showDocument(link[0]);
            }
        });
        link1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                services.showDocument(link[1]);
            }
        });

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
                if (Account.accounts != null){
                    // this is not working, change it to check if the user submitted his data correctly if so, let him play the game
                    GameViewManager gameManager = new GameViewManager();
                    gameManager.createNewGame(mainStage, chosenTheme);
                } else {
                    System.out.println("Enter your user name");
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
        createContinueButton();
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

    private void createContinueButton(){
        Button button = new Button("CONTINUE");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y +100) ;
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
                showSubScene(createContinueSubScene);
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createScoreButton(){
        Button button = new Button("SCORE");
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
              showSubScene(scoreSubScene);
            }
        });
        mainPane.getChildren().add(button);
    }
    private void createHelpButton(){
        Button button = new Button("HELP");
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + 300);
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
        button.setLayoutY(MENU_BUTTON_START_Y + 400);
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
        button.setLayoutY(MENU_BUTTON_START_Y + 500);
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

}