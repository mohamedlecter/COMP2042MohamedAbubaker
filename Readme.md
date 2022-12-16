Name: Mohamed Abubaker Mohamed

Student ID: 20302059

### **Compiling the program**
The program was programmed using Intellij, to compile it in intellij, click on edit configurations choose com.example.demo.Main as the main class 

### **Basic Maintenance**
1. I have deleted some unused code, unused libraries. 
2. Encapsulation was added to the classes that needed encapsulation. 
3. Renamed some classes and methods to make more sense.
4. Bug fix 
   * there was a bug in the score where it gets added whenever any key is presses
   * there was a bug that any key presses in the keyboard makes a move in the game


### **Additions**

1. Main menu that has:
    * Login page (where users can login and pick the desired theme, mode).
    * Leadreboard page (gets the name of the user when logging in and the score when the game ends, these values are stored in a text file).
      * notes:
        * there is a bug in the leaderboard, when the user quits in the middle of the game, no score gets added in the text file and then the leaderboard doesn't show any records 
        * when testing pleases change  `static File file = new File("D:\\Uni\\Y2\\COMP2042MohamedAbubaker\\src\\main\\java\\com\\example\\demo\\data.txt");` to the new location of the file
    * Help page.
    * Credits page.
    * Exit game button.
2. Different mode game
   * Easy mode: 5x5 grid.
   * Medium mode: 4x4.
   * Hard mode: 3x3 grid.
3. Game timer.
4. Help button. 
5. Reset game button.
6. Exit button.
7. Audio setting (not working as it should).
7. Save game button (not working as it should).
8. Load game button (not working as it should).
4. Try again button at the end of the game.
5. A score pop up at the end of the game.
5. Javadoc (under javadocs folder).
6. JUnit test 

### Added Java classes
* GameViewManager.java
* MainMenu.java
* MainMenuSubScence.java
* MenuSubScene.java
* InfoLable.java
* ScoreLeaderBoard.java
* Directions.java

### Modified Java classes
* EndGame.java -> added more buttons to the end game scene such as try again, quit, score pop up
* GameScene.java -> added more buttons to the game scene, such as help, settings, reset and exit
* TextMaker.java -> modified the text style
* Cell.java -> modified the alignment of the cells(made it to be in the center of the game)




