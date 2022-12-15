package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *  this class is responsible for creating the end game scene
 * @author mohamed abubaker-modified
 */
public class EndGame {
    private static EndGame singleInstance = null;
    static File file = new File("D:\\Uni\\Y2\\Software Maintenance\\src\\main\\java\\com\\example\\demo\\data.txt");

    private EndGame(){
    }

    /**
     *
     * @return singleInstance
     */
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    /**
     *
     * @param endGameScene end game scene
     * @param root root of the game
     * @param primaryStage the primary stage of the game
     * @param score the score of the game
     */
    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage, long score){
        /**
         * this sets the background color to be the same user's choice
         */
        endGameScene.setFill(Paint.valueOf(MainMenuSubScence.themeColor));

        Text text = new Text("GAME OVER");
        text.relocate(250,250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        Text scoreText = new Text("Score: "+score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(250,500);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);

        Popup popup = new Popup();
        Label scoreLabel = new Label("Score: " + score +"");
        scoreLabel.setStyle(" -fx-background-color: white;");
        scoreLabel.setMinWidth(80);
        scoreLabel.setMinHeight(50);
        popup.getContent().add(scoreLabel);

        Button popUpBtn = new Button("Pop up the score");
        popUpBtn.setPrefSize(150,30);
        popUpBtn.setTextFill(Color.BLACK);
        popUpBtn.relocate(150,600);
        popUpBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!popup.isShowing()){
                    popup.show(primaryStage);
                }else
                    popup.hide();
            }
        });
        root.getChildren().add(popUpBtn);

        Button resetGameButton = new Button("TRY AGAIN");
        resetGameButton.setPrefSize(100,30);
        resetGameButton.setTextFill(Color.BLACK);
        resetGameButton.relocate(350,600);
        resetGameButton.setFocusTraversable(false);
        root.getChildren().add(resetGameButton);
        resetGameButton.setOnAction(e ->{
            Main newGame = new Main();
            try {
                primaryStage.close();
                newGame.start(primaryStage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.BLACK);
        quitButton.relocate(500,600);
        root.getChildren().add(quitButton);
        quitButton.setOnAction(e ->{
            GameScene scene = new GameScene();
            scene.exitScreen();
        });
        //the score gets stored in the data file
            try{
                if(!file.exists()){
                    System.out.println("File was not found, a new file file was created");
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(String.valueOf(score));
                bufferedWriter.close();
            }
            catch (Exception error){
                System.out.println(error);
            }
        root.getChildren().add(quitButton);
    }
}
