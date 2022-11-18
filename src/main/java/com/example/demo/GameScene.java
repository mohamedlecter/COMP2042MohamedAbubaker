package com.example.demo;

import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WritableBooleanValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

class GameScene extends Directions {

    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");

//        Button pauseButton = new Button("PAUSE");
//        pauseButton.setPrefSize(100,30);
//        pauseButton.setTextFill(Color.BLACK);
//        root.getChildren().add(pauseButton);
//        pauseButton.relocate(250,750);
//        pauseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setTitle("PAUSE");
//                alert.setHeaderText("Quit from this page");
//                alert.setContentText("Are you sure?");
//
//                Optional<ButtonType> result = alert.showAndWait();
//                if (result.get() == ButtonType.OK){
//                    root.getChildren().clear();
//                }
//            }
//        });


//        Button tryAgainButton = new Button("TRY AGAIN");
//        tryAgainButton.setPrefSize(100,30);
//        tryAgainButton.setTextFill(Color.BLACK);
//        root.getChildren().add(tryAgainButton);
//        tryAgainButton.relocate(400,750);
//        tryAgainButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setTitle("Quit Dialog");
//                alert.setHeaderText("Quit from this page");
//                alert.setContentText("Are you sure?");
//
//                Optional<ButtonType> result = alert.showAndWait();
//                if (result.get() == ButtonType.OK){
//                    root.getChildren().clear();
//                }
//            }
//        });
//
//        Button aboutButton = new Button("ABOUT");
//        aboutButton.setPrefSize(100,30);
//        aboutButton.setTextFill(Color.BLACK);
//        root.getChildren().add(aboutButton);
//        aboutButton.relocate(400,750);
//        aboutButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setTitle("Quit Dialog");
//                alert.setHeaderText("Quit from this page");
//                alert.setContentText("Are you sure?");
//
//                Optional<ButtonType> result = alert.showAndWait();
//                if (result.get() == ButtonType.OK){
//                    root.getChildren().clear();
//                }
//            }
//        });
//
//        Button quitButton = new Button("QUIT");
//        quitButton.setPrefSize(100,30);
//        quitButton.setTextFill(Color.BLACK);
//        root.getChildren().add(quitButton);
//        quitButton.relocate(100,750);
//        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setTitle("Quit Dialog");
//                alert.setHeaderText("Quit from this page");
//                alert.setContentText("Are you sure?");
//
//                Optional<ButtonType> result = alert.showAndWait();
//                if (result.get() == ButtonType.OK){
//                    root.getChildren().clear();
//                }
//            }
//        });





        randomFillNumber(1);
        randomFillNumber(1);
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    int haveEmptyCell;
                    if (key.getCode() == KeyCode.DOWN) {
                        GameScene.this.moveDown();
                    } else if (key.getCode() == KeyCode.UP) {
                        GameScene.this.moveUp();
                    } else if (key.getCode() == KeyCode.LEFT) {
                        GameScene.this.moveLeft();
                    } else if (key.getCode() == KeyCode.RIGHT) {
                        GameScene.this.moveRight();
                    }
                    GameScene.this.sumCellNumbersToScore();
                    scoreText.setText(score + "");
                    haveEmptyCell = GameScene.this.haveEmptyCell();
                    if (haveEmptyCell == -1) {
                        if (GameScene.this.canNotMove()) {
                            primaryStage.setScene(endGameScene);

                            EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                            root.getChildren().clear();
                            score = 0;
                        }
                    } else if(haveEmptyCell == 1)
                        GameScene.this.randomFillNumber(2);
                });
            });
    }
}
