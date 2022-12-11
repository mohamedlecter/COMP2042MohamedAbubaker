package com.example.demo;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author mohamed abubaker-modified
 */
public class Main extends Application {

    /**
     * this is the main class that takes:
     * @param primaryStage
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

    public static void main(String[] args) {
        launch(args);
    }
}
