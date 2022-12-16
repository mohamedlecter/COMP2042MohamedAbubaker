package com.example.demo;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
/**
 * @author mohamed abubaker-modified
 */
class GameScene extends Directions {
    static Label scoreLabel = new Label();
    private Label timerLabel;
    public static long startTime;
    public static long elapsedTime;
    public static AnimationTimer timer;
    /**
     *
     * @param gameScene indicates the game scene that will be shown in the game
     * @param root indicate the group root
     * @param primaryStage the primary stage of the game.
     * @param endGameScene end game scene (which is shown after the game)
     * @param endGameRoot end game root
     */
    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }
        Text titleOfGame = new Text();
        root.getChildren().add(titleOfGame);
        titleOfGame.setText("2048");
        titleOfGame.setFont(Font.font( "Calibri", FontWeight.BOLD, 50));
        titleOfGame.relocate(100, 80);

        // Create label to display the timer
        timerLabel = new Label("Timer: 0 seconds");
        timerLabel.setFont(Font.font( "Calibri", FontWeight.BOLD, 20));
        timerLabel.setTextFill(Color.BLACK);
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Calculate the time elapsed and update the label
                elapsedTime = System.currentTimeMillis() - startTime;
                timerLabel.setText("Timer: " + elapsedTime / 1000 + " seconds");
            }
        };

        VBox layout = new VBox();
        layout.getChildren().addAll(timerLabel);
        layout.relocate(400, 80);
        root.getChildren().add(layout);

        // Sets the font and alignment for the score Label.
        scoreLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 30));
        scoreLabel.setText("Score\n");
        scoreLabel.setTextFill(Color.BLACK);
        scoreLabel.relocate(900, 80);
        root.getChildren().add(scoreLabel);

        Text scoreCounterText = new Text();
        scoreCounterText.setFont(Font.font(20));
        scoreCounterText.setText("0");
        scoreCounterText.relocate(900, 110);
        scoreCounterText.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(scoreCounterText);

        Button settingsButton = new Button("Settings");
        settingsButton.setFocusTraversable(false);
        settingsButton.setLayoutX(300);
        settingsButton.setLayoutY(50);
        settingsButton.setOnAction(e ->{
            settingsScreen();
        });

        Button helpButton = new Button("Help");
        helpButton.setFocusTraversable(false);
        helpButton.setOnAction(e ->{
            helpScreen();
        });

        Button exitButton = new Button("Exit");
        exitButton.setFocusTraversable(false);
        exitButton.setOnAction(e ->{
                exitScreen();
        });

        Button resetGameButton = new Button("Reset Game");
        resetGameButton.setFocusTraversable(false);
        resetGameButton.setOnAction(e ->{
            GameViewManager gameManager = new GameViewManager();
            gameManager.createNewGame(primaryStage);
            startTime = System.currentTimeMillis();
            timer.start();
        });

        Button loadButton = new Button("Load");
        loadButton.setFocusTraversable(false);
        loadButton.setOnAction(e ->{

        });

        Button saveButton = new Button("Save");
        saveButton.setFocusTraversable(false);
        saveButton.setOnAction(e ->{

        });

        //Puts all the ALT buttons in an HBox on the bottom of the stage.
        HBox buttons = new HBox(115);
        buttons.getChildren().addAll(helpButton, loadButton, saveButton, settingsButton, resetGameButton, exitButton);
        buttons.setLayoutX(100);
        buttons.setLayoutY(690);
        root.getChildren().add(buttons);

        // creates two number in random cells
        randomFillNumber();
        randomFillNumber();
        gameScene.addEventHandler(KeyEvent.KEY_RELEASED, key ->{
                Platform.runLater(() -> {
                    int haveEmptyCell;
                    // movements controller
                    if (key.getCode() == KeyCode.DOWN) {
                        GameScene.this.moveDown();
                    } else if (key.getCode() == KeyCode.UP) {
                        GameScene.this.moveUp();
                    } else if (key.getCode() == KeyCode.LEFT) {
                        GameScene.this.moveLeft();
                    } else if (key.getCode() == KeyCode.RIGHT) {
                        GameScene.this.moveRight();
                    }
                    else {
                        return;
                    }
                    scoreCounterText.setText(String.valueOf(score));
                    haveEmptyCell = GameScene.this.haveEmptyCell();
                    if (haveEmptyCell == -1) {
                        if (GameScene.this.canNotMove()) {
                            primaryStage.setScene(endGameScene);
                            EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                            root.getChildren().clear();
                            score = 0;
                        }
                    } else if(haveEmptyCell == 1)
                        GameScene.this.randomFillNumber();
                });
            });
    }

    /**
     * this function sets up a new screen that will be called when the user presses on help button
     */
    private void helpScreen(){
        Stage helpScreen = new Stage();

        Label help = new Label("Basically, 2048 presents with with a 4×4 grid. When you start the game, \n" +
                "there will be two “tiles” on the grid, each displaying the number 2 or 4.\n" +
                " You hit the arrow keys on your keyboard to move the tiles around — \n" +
                "and also to generate new tiles, which will also be valued at 2 or 4. \n" +
                "When two equal tiles collide, they combine to give you one greater tile that displays their sum.\n " +
                "The more you do this, obviously, the higher the \n tiles get and the more crowded the board becomes.\n " +
                "Your objective is to reach 2048 before the board fills up.");
        help.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 20));

        BorderPane helpSizing = new BorderPane();
        helpSizing.setCenter(help);

        Scene helpScene = new Scene(helpSizing); // Create a scene.
        helpScreen.setResizable(false); // Sets the output to not resizeable.
        helpScreen.setTitle("Help and Instructions"); // Set the stage title.
        helpScreen.setHeight(300); // sets the height and width of the scene
        helpScreen.setWidth(800);
        helpScreen.setScene(helpScene); // Put the scene in the stage.
        helpScreen.show();
    }
    /**
     * this function sets up a new screen that will be called when the user presses on exit button
     */
    public void exitScreen() {
        Stage exitScreen = new Stage();

        Label gameOverLabel = new Label("Are you sure you want to exit the game? \n");
        gameOverLabel.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
        gameOverLabel.setPadding(new Insets(10, 10 ,10 , 10));

        Button closeBtn = new Button("YES");
        closeBtn.setFont(Font.font("Calibri", 16));
        closeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                timer.stop();
                exitScreen.close();
                System.exit(0);
            }
        });

        Button dontCloseBtn = new Button("NO");
        dontCloseBtn.setFont(Font.font("Calibri", 16));
        dontCloseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                exitScreen.close();
            }
        });

        BorderPane exitScreenContainer = new BorderPane();
        exitScreenContainer.setTop(gameOverLabel);
        exitScreenContainer.setRight(closeBtn);
        exitScreenContainer.setLeft(dontCloseBtn);
        exitScreenContainer.setPadding(new Insets(10, 10, 10, 10));


        Scene mssgScene = new Scene(exitScreenContainer);
        exitScreen.setResizable(false);
        exitScreen.setTitle("Exit game!");
        exitScreen.setHeight(200);
        exitScreen.setWidth(400);
        exitScreen.setScene(mssgScene);
        exitScreen.show();
    }
    /**
     * this function sets up a new screen that will be called when the user presses on settings button
     */
    private void settingsScreen() {
        Stage settingsScreen = new Stage();

        Label audioLabel = new Label("Audio");
        audioLabel.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 20));
        RadioButton audioOn = new RadioButton("On");
        RadioButton audioOff= new RadioButton("Off");

        BorderPane options = new BorderPane();
        options.setLeft(audioOn);
        options.setRight(audioOff);

        BorderPane settingsScreenContainer = new BorderPane();
        settingsScreenContainer.setLeft(audioLabel);
        settingsScreenContainer.setRight(options);
        settingsScreenContainer.setPadding(new Insets(10, 10, 10, 10));

        Scene settingsScene = new Scene(settingsScreenContainer);
        settingsScreen.setResizable(false);
        settingsScreen.setTitle("Settings");
        settingsScreen.setHeight(150);
        settingsScreen.setWidth(500);
        settingsScreen.setScene(settingsScene);
        settingsScreen.show();
    }
}
