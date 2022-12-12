package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

        Button resetGameButton = new Button("TRY AGAIN");
        resetGameButton.setPrefSize(100,30);
        resetGameButton.setTextFill(Color.BLACK);
        resetGameButton.relocate(250,600);
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
