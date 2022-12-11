package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *  this class is responsible for creating a new game scene, it's called after pressing the start button in the game menu
 * @author mohamed abubaker
 */
public class GameViewManager {
    private Stage gameStage;
    private  static final int GAME_WIDTH = 1000;
    private static  final int GAME_HEIGHT = 750;
    private Stage menuStage;
    Group menuRoot = new Group();
    Scene menuScene = new Scene(menuRoot, GAME_WIDTH,GAME_HEIGHT);
    Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, GAME_WIDTH, GAME_HEIGHT, Color.rgb(250, 20, 100, 0.2));
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, GAME_WIDTH, GAME_HEIGHT, Color.rgb(189, 177, 92));


    public void setGameScene(Scene gameScene) {
            this.gameScene = gameScene;
        }
    public void setGameRoot(Group gameRoot) {
            this.gameRoot = gameRoot;
        }

    public GameViewManager(){
    }
    public void createNewGame(Stage menuStage){
        this.menuStage = menuStage;
        this.menuStage.hide();
        game();
        gameStage.show();
    }

    private void game(){
        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
        backgroundOfMenu.setX(GAME_WIDTH / 2 - 120);
        backgroundOfMenu.setY(180);
        menuRoot.getChildren().add(backgroundOfMenu);

        gameStage = new Stage();
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, GAME_WIDTH, GAME_HEIGHT, Paint.valueOf(MainMenuSubScence.themeColor));
        setGameScene(gameScene);
        gameStage.setScene(gameScene);
        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, gameStage, endGameScene, endgameRoot);

    }

}

