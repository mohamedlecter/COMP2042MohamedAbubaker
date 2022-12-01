package com.example.demo;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GameViewManager {
    private Stage gameStage;
    private  static final int GAME_WIDTH = 1000;
    private static  final int GAME_HEIGHT = 750;
    private Stage menuStage;
    Group menuRoot = new Group();
    Scene menuScene = new Scene(menuRoot, GAME_WIDTH,GAME_HEIGHT);
    Group accountRoot = new Group();
    Scene accountScene = new Scene(accountRoot, GAME_WIDTH, GAME_HEIGHT, Color.rgb(150, 20, 100, 0.2));
    Group getAccountRoot = new Group();
    Scene getAccountScene = new Scene(getAccountRoot, GAME_WIDTH, GAME_HEIGHT, Color.rgb(200, 20, 100, 0.2));
    Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, GAME_WIDTH, GAME_HEIGHT, Color.rgb(250, 20, 100, 0.2));
    Group rankRoot = new Group();
    Scene rankScene = new Scene(rankRoot, GAME_WIDTH, GAME_HEIGHT, Color.rgb(250, 50, 120, 0.3));
    BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
    Background background = new Background(background_fill);
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, GAME_WIDTH, GAME_HEIGHT, Color.rgb(189, 177, 92));


    public void setGameScene(Scene gameScene) {
            this.gameScene = gameScene;
        }
    public void setGameRoot(Group gameRoot) {
            this.gameRoot = gameRoot;
        }

    public GameViewManager(){
        initStage();
        createKeyListeners();
    }

    private void createKeyListeners(){

    }

    private void initStage(){

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

        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
        backgroundOfMenuForPlay.setX(GAME_WIDTH / 2 - 120);
        backgroundOfMenuForPlay.setY(180);
        accountRoot.getChildren().add(backgroundOfMenuForPlay);

        gameStage = new Stage();
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, GAME_WIDTH, GAME_HEIGHT, Paint.valueOf(viewManager.themeColor));
        setGameScene(gameScene);
        gameStage.setScene(gameScene);
        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, gameStage, endGameScene, endgameRoot);

    }

}

