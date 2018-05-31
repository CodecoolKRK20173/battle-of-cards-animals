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
    private int playerOneIndex = 0;
    private int playerTwoIndex = 1;
    private int playerThreeIndex = 2;
    private int playerFourIndex = 3;
    private String fileName = "about_the_game.txt";

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
                    display.displayAboutGame(fileName);
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
        exitGame();
    }

    public void playGame() {
        table.dealCards();
        setRandomPlayerWinnerStatus();
        while(!gameOver()) {
            table.dealCardsOnTheTable();

            Player roundWinner = getWinnerOfLastRound();

            int lastRoundWinner = getWinnerOfLastRoundIndex();

            showWinnerCardStatistic(lastRoundWinner);

            int playerChoice = getPlayerStatisticChoice(roundWinner);

            chooseStatisticToCompare(playerChoice);

            System.out.println(table.tableToString());

            double maxValue = getMaxiumumElement();


            while(playersHaveCards() && checkIfThereIsTie(maxValue)) {
                
                addCardsFromTableToStack();
                table.clearLists();

                table.dealCardsOnTheTable();
                chooseStatisticToCompare(playerChoice);
                maxValue = getMaxiumumElement();
            }

            int winnerIndex = getIndexOfRoundWinner();

            switchPlayerWinnerStatus(winnerIndex);
            addCardsToPlayersDeck();

            table.clearLists();
            table.clearStack();

        }
    }

    public boolean playersHaveCards() {
        for(Player p: table.getPlayers()) {
            if(p.getHand().getCards().size() == 0){
                return false;
            }
        }
        return true;
    }


    public void showIfThereIsCardInStack() {
        // if(table.getCardsFromTie().size() > 0) {
        //     System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        //     System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        //     System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n");
        // }
        for(int i = 0; i < table.getCardsFromTie().size(); i++) {
            System.out.println("Card: " + table.getCardsFromTie().get(i).getName());
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

    public Player getWinnerOfLastRound() {
        Player winner = null;
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

    public int getIndexOfRoundWinner() {
        double maxValueIndex = getMaxiumumElement();
        int winnerIndex = table.getCardsStatistic().indexOf(maxValueIndex);
        return winnerIndex;
    }

    public Double getMaxiumumElement() {
        double maxValue = Collections.max(table.getCardsStatistic());
        System.out.println(table.getCardsStatistic().size());
        return maxValue;
    }


    public boolean checkIfThereIsTie(Double maxValue) {
        int maxValueOccurences = Collections.frequency(table.getCardsStatistic(), maxValue);
        if(maxValueOccurences > 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public Player getRoundWinnerPlayer() {
        int winnerIndex = getIndexOfRoundWinner();
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

    public void addCardsFromTieCardsListToPlayersDeck() {
        Player player = getRoundWinnerPlayer();
        for(int i = 0; i < table.getCardsOnTheTable().size(); i++) {
            player.getHand().addCardToHand(table.getCardsFromTie().get(i));
        }
    }

    public void addCardsFromTableToStack() {
        table.getCardsFromTie().addAll(table.getCardsOnTheTable());
        table.getCardsOnTheTable().clear();
    }

    public void clearListOfCardsAndListOfStatistic() {
        table.getCardsOnTheTable().clear();
        table.getCardsStatistic().clear();
        table.getCardsFromTie().clear();
    }

    public void clearListOfStatistic() {
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
            table.addPlayer(createComputerPlayer("Computer " + (i + 1)));
        }
    }

    private void createComputerVsComputerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            table.addPlayer(createComputerPlayer("Computer " + (i + 1)));
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
        ArrayList<Player> players = table.getPlayers();
        if(players.size() == 2) {
            return gameOverWithTwoPlayers();
        }
        else if (players.size() == 3) {
            return gameOverWithThreePlayers();
        }
        else if (players.size() == 4) {
            return gameOverWithFourPlayers();
        }
        else {
            return false;
        }
        
    }

    public boolean gameOverWithTwoPlayers () {
        ArrayList<Player> players = table.getPlayers();
        if(players.get(playerOneIndex).getHand().getCards().size() == 0 || 
           players.get(playerTwoIndex).getHand().getCards().size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean gameOverWithThreePlayers() {
        ArrayList<Player> players = table.getPlayers();
        if(players.get(playerOneIndex).getHand().getCards().size() == 0 || 
           players.get(playerTwoIndex).getHand().getCards().size() == 0 ||
           players.get(playerThreeIndex).getHand().getCards().size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean gameOverWithFourPlayers() {
        ArrayList<Player> players = table.getPlayers();
        if(players.get(playerOneIndex).getHand().getCards().size() == 0 || 
           players.get(playerTwoIndex).getHand().getCards().size() == 0 ||
           players.get(playerThreeIndex).getHand().getCards().size() == 0 ||
           players.get(playerFourIndex).getHand().getCards().size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void exitGame() {
        System.exit(0);
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
