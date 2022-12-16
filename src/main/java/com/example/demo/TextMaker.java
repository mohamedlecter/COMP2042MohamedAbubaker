package com.example.demo;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author mohamed abubaker-modified
 */
class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {
    }

    static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     *
     * @param input the number of the cell
     * @param xCell x coordinate of the cell
     * @param yCell y coordinate of the cell
     * @param root root
     * @return text
     */
    Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font( "Calibri", FontWeight.BOLD, 25));
        text.relocate((xCell + 265), (yCell + 120));
        text.setFill(Color.WHITE);

        return text;
    }

    /**
     *
     * @param first first text
     * @param second second text
     */

    static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);

    }

}
