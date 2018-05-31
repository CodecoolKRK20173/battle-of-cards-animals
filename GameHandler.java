import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;




public class GameHandler {

    private Scanner reader = new Scanner(System.in);

    private int choice;
    private int numberOfHumanPlayers;
    private int numberOfPlayers;

    Display display = new Display();
    Table table = new Table();

    Scanner scanner = new Scanner(System.in);

    Random rand = new Random();


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
        printPlayers();
        table.dealCards();
        setRandomPlayerWinnerStatus();
        while(!gameOver()) {
            table.dealCardsOnTheTable();

            System.out.println("\nPLAYER STATUS!!!!");
            showPlayersStatuses();
            System.out.println("__________________\n");

            showPlayerHandSize();

            showListListOfCardsAndListOfStatistic();

            // int playerChoice = switchPlayers();

            Player roundWinner = getWinnerOfLastRound();

            int lastRoundWinner = getWinnerOfLastRoundIndex();

            showWinnerCardStatistic(lastRoundWinner);

            int playerChoice = getPlayerStatisticChoice(roundWinner);

            chooseStatisticToCompare(playerChoice);

            showStatistic();

            int winnerIndex = getIndexOfMaxiumumElement();

            switchPlayerWinnerStatus(winnerIndex);

            addCardsToPlayersDeck();

            showPlayerHandSize();

            clearListOfCardsAndListOfStatistic();

            showListListOfCardsAndListOfStatistic();

            boolean isOver = gameOver();
        }

    }


    public int getWinnerOfLastRoundIndex() {
        int lastRoundWinner = 0;
        for(int i = 0; i < table.getPlayers().size(); i++) {
            if(table.getPlayers().get(i).getRoundWinner()) {
                lastRoundWinner = i;
            }
        }
        return lastRoundWinner;

    }


    public void showPlayersStatuses() {
        for(int i = 0; i < table.getPlayers().size(); i++) {
            System.out.println("Player: " + table.getPlayers().get(i).getName() + " - status: " + table.getPlayers().get(i).getRoundWinner());
        }
    }



    public void showPlayerHandSize() {
        for(int i = 0; i < table.getPlayers().size(); i++) {
            System.out.println(table.getPlayers().get(i).getHand().getCardsAmount());
        }
    }



    public void showListListOfCardsAndListOfStatistic() {
        if(table.getCardsOnTheTable().size() > 0) {
            System.out.println("You have cards here!");
        }
        else {
            System.out.println("EMPTY LIST!!!");
        }
    }


    public void showStatistic() {
        for(int i = 0; i < table.getCardsStatistic().size(); i++) {
            System.out.println("Player " + i + " card statistic: " + table.getCardsStatistic().get(i));
        }
    }


    public void printPlayers() {
        for(int i = 0; i < table.getPlayers().size(); i++) {
            System.out.println("Player: " + table.getPlayers().get(i).getName());
        }
    }


    public void setRandomPlayerWinnerStatus() {
        int randomPlayer = rand.nextInt(table.getPlayers().size());
        table.getPlayers().get(randomPlayer).setRoundWinner();
        System.out.println("Player " + table.getPlayers().get(randomPlayer).getName() + " has WINNER STATUS!");
    }


    public void showWinnerCardStatistic(int winnerIndex) {

        System.out.println("CARD STATISTIC\n");
        System.out.println("Top speed: " + table.getCardsOnTheTable().get(winnerIndex).getTopSpeed());
        System.out.println("Max length: " + table.getCardsOnTheTable().get(winnerIndex).getMaxLength());
        System.out.println("Max weigth: " + table.getCardsOnTheTable().get(winnerIndex).getMaxWeigth());
        System.out.println("Food: " + table.getCardsOnTheTable().get(winnerIndex).getFood());
        System.out.println("Life span: " + table.getCardsOnTheTable().get(winnerIndex).getLifeSpan());
        System.out.println("\n");

    }


    // public int switchPlayers() {

    //     int playerChoice = 1;

    //     for(int i = 0; i < table.getPlayers().size(); i++){
    //         if(table.getPlayers().get(i).getRoundWinner()) {
    //             playerChoice = table.getPlayers().get(i).makeMove();
    //             String playerName = table.getPlayers().get(i).getName();
    //             System.out.println("Player " + playerName + " make the move!");
    //         }
    //     }
    //     return playerChoice;
    // }



    public Player getWinnerOfLastRound() {

        Player winner = table.getPlayers().get(1);
        
        for(int i = 0; i < table.getPlayers().size(); i++) {
            if(table.getPlayers().get(i).getRoundWinner()) {
                winner = table.getPlayers().get(i);
            }
        }
        return winner;
    }


    public int getPlayerStatisticChoice(Player roundWinner) {
        int playerChoice = roundWinner.makeMove();
        return playerChoice;
    }


    public void chooseStatisticToCompare(int playerChoice) {
        
        if(playerChoice == 1) {
            compareTopSpeed();
        }
        else if(playerChoice == 2) {
            compareMaxLength();
        }
        else if(playerChoice == 3) {
            compareMaxWeigth();
        }
        else if(playerChoice == 4) {
            compareFood();
        }
        else {
            compareLifeSpan();
        }     
    }


    public int getIndexOfMaxiumumElement() {
        double maxValue = Collections.max(table.getCardsStatistic());
        int winnerIndex = table.getCardsStatistic().indexOf(maxValue);
        return winnerIndex;
    }


    public Player getRoundWinnerPlayer() {
        int winnerIndex = getIndexOfMaxiumumElement();
        Player winner = table.getPlayers().get(winnerIndex);
        return winner;
    }


    public void switchPlayerWinnerStatus(int winnerIndex) {
        for(int i = 0; i < table.getPlayers().size(); i++) {
            if(i == winnerIndex) {
                table.getPlayers().get(i).setRoundWinner();
            }else {
                table.getPlayers().get(i).setRoundLooser();
            }
        }
    }


    public void addCardsToPlayersDeck() {
        Player player = getRoundWinnerPlayer();
        for(int i = 0; i < table.getCardsOnTheTable().size(); i++) {
            player.getHand().addCardToHand(table.getCardsOnTheTable().get(i));
        }
    }


    // public void clearListOfCardsAndListOfStatistic() {
    //     for(int i = 0; i < table.getCardsOnTheTable().size(); i++) {
    //         table.getCardsOnTheTable().remove(i);
    //         table.getCardsStatistic().remove(i); 
    //     }
    // }


    public void clearListOfCardsAndListOfStatistic() {
        table.getCardsOnTheTable().clear();
        table.getCardsStatistic().clear();
    }
    

    public void compareTopSpeed() {
        for(int i = 0; i < table.getCardsOnTheTable().size(); i++) {
            table.getCardsStatistic().add(table.getCardsOnTheTable().get(i).getTopSpeed());
        }
    }


    public void compareMaxLength() {
        for(int i = 0; i < table.getCardsOnTheTable().size(); i++) {
            table.getCardsStatistic().add(table.getCardsOnTheTable().get(i).getMaxLength());
        }
    }


    public void compareMaxWeigth() {
        for(int i = 0; i < table.getCardsOnTheTable().size(); i++) {
            table.getCardsStatistic().add(table.getCardsOnTheTable().get(i).getMaxWeigth());
        }
    }


    public void compareFood() {
        for(int i = 0; i < table.getCardsOnTheTable().size(); i++) {
            table.getCardsStatistic().add(table.getCardsOnTheTable().get(i).getFood());
        }
    }


    public void compareLifeSpan() {
        for(int i = 0; i < table.getCardsOnTheTable().size(); i++) {
            table.getCardsStatistic().add(table.getCardsOnTheTable().get(i).getLifeSpan());
        }
    }


    private int chooseNumberOfPlayers() {
        System.out.print("Please choose number of players - 2, 3 or 4: ");
        int numberOfPlayers = getChoice();
        return numberOfPlayers;
    }


    private void createPlayerVsPlayerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            table.addPlayer(createHumanPlayer());
        }
    }


    private void createPlayerVsComputerMode(int numberOfPlayers) {
        int numberOfHumanPlayers = 1;
        table.addPlayer(createHumanPlayer());
        for(int i = 0; i < numberOfPlayers - numberOfHumanPlayers; i++) {
            table.addPlayer(createComputerPlayer("Computer " + i));
        }
    }


    private void createComputerVsComputerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            table.addPlayer(createComputerPlayer("Computer " + i));
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
        ArrayList<Player> players = table.getPlayers();
        for(int i = 0; i < table.getPlayers().size(); i++) {
            if(players.get(i).getHand().getCards().size() == 0) {
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
