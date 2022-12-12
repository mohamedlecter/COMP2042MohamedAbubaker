package com.example.demo;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class that has the main method.
 * @author mohamed abubaker-modified
 */
public class Main extends Application {

    /**
     * this is the main class that takes:
     * @param primaryStage the primary stage of the game.
     * @throws Exception, in case there is any error, this argument throws an error
     * as arguments which are needed to start the JavaFx program
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            MainMenu manager = new MainMenu();
            primaryStage = manager.getMainStage();
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Main method. The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
