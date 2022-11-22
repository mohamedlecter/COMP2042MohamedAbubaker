package com.example.demo;

import com.example.demo.modle.THEME;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScence;
    private Stage gameStage;

    private  static final int GAME_WIDTH = 600;
    private static  final int GAME_HEIGHT = 800;

    private Stage menuStage;
    private ImageView theme;

    public GameViewManager(){
        initStage();
        createKeyListeners();
    }

    private void createKeyListeners(){

    }

    private void initStage(){
        gamePane = new AnchorPane();
        gameScence = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScence);
    }

    public void createNewGame(Stage menuStage, THEME chosenTheme){
        this.menuStage = menuStage;
        this.menuStage.hide();
        gameStage.show();
    }
}

//        Group menuRoot = new Group();
//        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
//        Group accountRoot = new Group();
//        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
//        Group getAccountRoot = new Group();
//        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
//        Group endgameRoot = new Group();
//        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
//        Group rankRoot = new Group();
//        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
//        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
//        Background background = new Background(background_fill);
//
//
//        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
//        backgroundOfMenu.setX(WIDTH / 2 - 120);
//        backgroundOfMenu.setY(180);
//        menuRoot.getChildren().add(backgroundOfMenu);
//
//        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
//        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
//        backgroundOfMenuForPlay.setY(180);
//        accountRoot.getChildren().add(backgroundOfMenuForPlay);
//
//        Group gameRoot = new Group();
//        setGameRoot(gameRoot);
//        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
//        setGameScene(gameScene);
//        primaryStage.setScene(gameScene);
//        GameScene game = new GameScene();
//        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
//
//        primaryStage.show();