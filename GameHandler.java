import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;




public class GameHandler {

    private Scanner reader = new Scanner(System.in);

    private int choice;
    private int numberOfHumanPlayers;
    private int numberOfPlayers;

    private ArrayList<Player> players = new ArrayList<>();

    Display display = new Display();
    Table table = new Table();


    public void runApplication() {

        boolean quit = false;
        while(!quit) {
            display.displayMainMenu();
            System.out.print("Please enter your choice: ");
            int choice = getChoice();

            switch(choice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    display.displayAboutGame();
                    break;
                case 3:
                    quit = true;
                    break;
            }
        }
    }



    public void startGame() {
        display.displayGameMode();
        int choice = getChoice();
        switch(choice) {
            case 1:
                int numberOfPlayers = chooseNumberOfPlayers();
                createPlayerVsPlayerMode(numberOfPlayers);
                break;
            case 2:
                numberOfPlayers = chooseNumberOfPlayers();
                createPlayerVsComputerMode(numberOfPlayers);
                break;
            case 3:
                numberOfPlayers = chooseNumberOfPlayers();
                createComputerVsComputerMode(numberOfPlayers);
                break;
        }
        playGame();
    }


    public void playGame() {

        while(!gameOver()) {
            // players.get(index).makeMove();
        }

    }


    // public void switchPlayers() {

    //     for(int i = 0; i < table.listOfPlayers.size(); i++){
    //         if(table.listOfPlayers.get(i).getRoundWinner) {
    //             table.listOfPlayers.get(i).chooseStatisticToCompare();
    //         }
    //     }

    // }



    public int getIndexOfMaxiumumElement() {
        Collections.max(table.listOfCards);
    }


    public void compareTopSpeed() {
        for(int i = 0; i < listOfCards; i++) {
            listOfStatistic.add(listOfCards.get(i).getTopSpeed());
        }
    }


    public void compareMaxLength() {
        for(int i = 0; i < listOfCards; i++) {
            listOfStatistic.add(listOfCards.get(i).getMaxLength());
        }
    }


    public void compareMaxWeigth() {
        for(int i = 0; i < listOfCards; i++) {
            listOfStatistic.add(listOfCards.get(i).getMaxWeigth());
        }
    }


    public void compareFood() {
        for(int i = 0; i < listOfCards; i++) {
            listOfStatistic.add(listOfCards.get(i).getFood());
        }
    }


    public void compareLifeSpan() {
        for(int i = 0; i < listOfCards; i++) {
            listOfStatistic.add(listOfCards.get(i).getLifeSpan());
        }
    }


    public void addCardsToPlayersDeck() {
        player = getRoundWinnerIndex();
        for(int i = 0; i < listOfCards; i++) {
            player.add(listOfCards.get(i));
        }
    }


    public void clearListOfCards() {
        for(int i = 0; i < listOfCards; i++) {
            listOfCards.remove(i);
        }
    }


    private int chooseNumberOfPlayers() {
        System.out.print("Please choose number of players - 2, 3 or 4: ");
        int numberOfPlayers = getChoice();
        return numberOfPlayers;
    }


    private void createPlayerVsPlayerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            players.add(createHumanPlayer());
        }
    }


    private void createPlayerVsComputerMode(int numberOfPlayers) {
        int numberOfHumanPlayers = 1;
        players.add(createHumanPlayer());
        for(int i = 0; i < numberOfPlayers - numberOfHumanPlayers; i++) {
            players.add(createComputerPlayer("Computer " + i));
        }
    }


    private void createComputerVsComputerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            players.add(createComputerPlayer("Computer " + i));
        }
    }


    public Player createHumanPlayer() {
        System.out.print("Please enter player name: ");
        String playerName = reader.next();
        System.out.println("Player " + playerName + " created!");
        return new HumanPlayer(playerName);
    }


    public Player createComputerPlayer(String computerName) {
        display.displayGameLevel();
        int choice = getChoice();
        switch(choice) {
            case 1:
                return new ComputerEasy(computerName);
            case 2:
                return new ComputerHard(computerName);
            default:
                System.out.println("Please choose 1 or 2!");
                return null;
        }
    }


    public boolean gameOver() {
        boolean isOver = false;
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).getNumberOfCards() == 0) {
                isOver = true;
            }
            else {
                isOver = false;
            }
        }
        return isOver;
    }



    private int getChoice() {
        boolean stopWhile = true;
        int option = 0;
        while(stopWhile) {
            this.reader = new Scanner(System.in);
            try {
                option = reader.nextInt();
                if(option >= 0 && option <= 6) {
                    stopWhile = false;
                }
                else {
                    display.displayMainMenu();
                }
            }
            catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
        return option;
    }





}
