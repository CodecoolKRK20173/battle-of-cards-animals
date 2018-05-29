// import java.util.InputMismatchException;
// import java.util.Scanner;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
//
//
//
//
// public class GameHandler {
//
//     private Scanner reader = new Scanner(System.in);
//
//     private int choice;
//     private int numberOfHumanPlayers;
//
//
//     private ArrayList<Player> players = new ArrayList<>();
//
//
//     Display display = new Display();
//
//
//
//     public void runApplication() {
//
//         boolean quit = false;
//         while(!quit) {
//             display.displayMainMenu();
//             System.out.print("Please enter your choice: ");
//             int choice = getChoice();
//
//             switch(choice) {
//                 case 1:
//                     startGame();
//                     break;
//                 case 2:
//                     display.displayAboutGame();
//                     break;
//                 case 3:
//                     quit = true;
//                     break;
//             }
//
//         }
//
//     }
//
//
//
//     public void startGame() {
//         display.displayGameMode();
//         int choice = getChoice();
//         switch(choice) {
//             case 1:
//                 initPlayers(2);
//                 break;
//             case 2:
//                 initPlayers(1);
//                 break;
//             case 3:
//                 initPlayers(0);
//                 break;
//
//         }
//
//         playGame();
//
//     }
//
//
//     public void playGame() {
//
//
//
//     }
//
//
//     public boolean gameOver() {
//         boolean isOver = false;
//         for(int i = 0; i < players.size(); i++) {
//             if(players.get(i).getNumberOfCards() == 0) {
//                 isOver = true;
//             }
//             else {
//                 isOver = false;
//             }
//         }
//         return isOver;
//     }
//
//
//     private int chooseNumberOfPlayers() {
//
//
//     }
//
//
//     private void initPlayers(int numberOfHumanPlayers) {
//         if(numberOfHumanPlayers == 2) {
//             players.add(createHumanPlayer());
//             players.add(createHumanPlayer());
//         }
//         else if (numberOfHumanPlayers == 1) {
//             players.add(createHumanPlayer());
//             players.add(createComputerPlayer("Computer One"));
//         }
//         else {
//             players.add(createComputerPlayer("Computer One"));
//             players.add(createComputerPlayer("Computer Two"));
//         }
//     }
//
//
//
//
//
//     public Player createHumanPlayer() {
//         System.out.print("Please enter player name: ");
//         String playerName = reader.nextLine();
//         return new HumanPlayer(playerName);
//     }
//
//
//     public Player createComputPlayer(String computerName) {
//         display.displayGameLevel();
//         int choice = getChoice();
//         switch(choice) {
//             case 1:
//                 return new ComputerEasy(computerName);
//             case 2:
//                 return new ComputerHard(computerName);
//             default:
//                 System.out.println("Please choose 1 or 2!");
//                 return null;
//         }
//     }
//
//
//
//     private int getChoice() {
//         boolean stopWhile = true;
//         int option = 0;
//         while(stopWhile) {
//             this.reader = new Scanner(System.in);
//             try {
//                 option = reader.nextInt();
//                 if(option >= 0 && option <= 6) {
//                     stopWhile = false;
//                 }
//                 else {
//                     display.displayMainMenu();
//                 }
//             }
//             catch (InputMismatchException e) {
//                 e.printStackTrace();
//             }
//         }
//         return option;
//     }
//
// }
