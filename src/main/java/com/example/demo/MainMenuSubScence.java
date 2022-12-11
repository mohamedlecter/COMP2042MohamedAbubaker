package com.example.demo;

import com.example.demo.modle.InfoLable;
import com.example.demo.modle.MenuSubScene;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainMenuSubScence{
    public static String themeColor;
    static MenuSubScene createStartGameSubScene;
    static MenuSubScene creditsSubScene;
    static MenuSubScene helpSubScene;
    static MenuSubScene scoreSubScene;
    static File file = new File("D:\\Uni\\Y2\\Software Maintenance\\src\\main\\java\\com\\example\\demo\\data.txt");
    private static final String BUTTON_STYLE = "-fx-background-color: black; -fx-text-fill: white";
    private static String userName;

    public MainMenuSubScence(AnchorPane mainPane, Stage mainStage){
        createSubScenes(mainPane, mainStage);
    }
    /**
     * this function works as a container for all the sub scenes where it takes these param:
     * @param mainPane
     * @param mainStage
     */
    public static void createSubScenes(AnchorPane mainPane, Stage mainStage){
        createStartGameSubScene(mainPane, mainStage);
        createscoreSubScene(mainPane);
        createHelpSubScene(mainPane);
        createCreditsSubScene(mainPane);
    }

    /**
     * this function creates the game sub scene by taking:
     * @param mainPane -> when creating the game sub scene, it'll be added to the main pane param
     * @param mainSatge -> when pressing on the start button, it passes the mainStage param so that the new game gets created
     */
    private static void createStartGameSubScene(AnchorPane mainPane, Stage mainSatge){
        createStartGameSubScene = new MenuSubScene();
        mainPane.getChildren().add(createStartGameSubScene);

        InfoLable helpLabel = new InfoLable("LOGIN");
        helpLabel.setLayoutX(120);
        helpLabel.setLayoutY(20);

        Label colorLabel = new Label("Pick you're desired theme ");
        colorLabel.setLayoutX(150);
        colorLabel.setLayoutY(80);
        // creating the color picker, on pressing the desired color, it's value gets stored in themeColor variable
        // that will be used when calling gameScene and pass the themeColor as the background color
        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setLayoutX(150);
        colorPicker.setLayoutY(100);
        colorPicker.setOnAction(e -> {
            themeColor = String.valueOf(colorPicker.getValue());
        });
        //Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setLayoutX(150);
        grid.setLayoutY(150);

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

        // Setting an action for the Submit button, where the username gets stored in a file that will be called
        // again when creating the high score list
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    if(!file.exists()){
                        System.out.println("File was not found, a new file file was created");
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write( name.getText() + " - ");
                    bufferedWriter.close();
                    userName = name.getText();
                }
                catch (Exception error){
                    System.out.println(error);
                }
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
        createStartGameSubScene.getPane().getChildren().addAll(helpLabel,colorLabel, colorPicker, grid, startBtn(mainSatge));

    }

    /**
     * this button is responsible for creating a new game on pressing it, where it will call gameManager.createNewGame and passes :
     * @param mainStage
     * @return
     */
    private static Button startBtn(Stage mainStage){
        Button button = new Button("START");
        button.setLayoutX(400);
        button.setLayoutY(350);
        button.setStyle(BUTTON_STYLE);
        button.setFont(Font.font("verdana", 23));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (userName!= null){
                    GameViewManager gameManager = new GameViewManager();
                    gameManager.createNewGame(mainStage);
                } else {
                    System.out.println("Enter your user name");
                }
            }
        });
        return button;
    }

    /**
     * this function creates a score list sub scene where it takes:
     * @param mainPane -> as params, when creating the score sub scene, it'll be added to the main pane
     */
    private static void createscoreSubScene(AnchorPane mainPane){
        scoreSubScene = new MenuSubScene();
        mainPane.getChildren().add(scoreSubScene);

        InfoLable scoreLabel = new InfoLable("Score list ");
        scoreLabel.setLayoutX(120);
        scoreLabel.setLayoutY(20);

        Text scoreText = new Text();
        scoreText.setLayoutX(120);
        scoreText.setLayoutY(80);
        scoreText.setFont(Font.font("verdana", 14));

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<ScoreLeaderBoard> leaders = new ArrayList<>();
            String x;
            while ((x = br.readLine()) != null) {
                ScoreLeaderBoard scoreLeaderBoard = new ScoreLeaderBoard();
                String[] splits = x.split(" - ");
                scoreLeaderBoard.setName(splits[0]);
                scoreLeaderBoard.setScore(Integer.parseInt(splits[1]));
                leaders.add(scoreLeaderBoard);
            }
            Collections.sort(leaders);
            StringBuilder leaderBoardStr = new StringBuilder();

            for (ScoreLeaderBoard leaderBoardEntry : leaders) {
                leaderBoardStr.append(leaderBoardEntry.getName())
                        .append(" - ")
                        .append(leaderBoardEntry.getScore())
                        .append("\n");
                System.out.println(leaderBoardEntry.getScore());
//                toDo ->  check if leaderBoardEntry.getScore() is empty i.e,
//                 user exits the in the middle of the game and the score is not saved, then display the score as not saved
            }
            String s = scoreText.getText();
            scoreText.setText( s + "\n" + leaderBoardStr.toString());

        } catch (Exception E) {
            System.out.println("cant read score leaderboard");
        }
        scoreSubScene.getPane().getChildren().addAll(scoreLabel, scoreText );
    }

    /**
     * this function creates a help sub scene that takes:
     * @param mainPane -> as params, when creating the help sub scene, it'll be added to the main pane
     */
    private static void createHelpSubScene(AnchorPane mainPane){
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

    /**
     * this function creates the credis sub scene where it takes
     * @param mainPane -> as params, when creating the credits sub scene, it'll be added to the main pane
     */

    private static void createCreditsSubScene(AnchorPane mainPane){
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

        String[]link = new String[6];
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


}