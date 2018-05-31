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
    private boolean afterFirstRound = false;
    GameMode[] values = GameMode.values();
    Display display = new Display();
    Deck deck = new Deck();
    Players players = new Players();
    RoundCards roundCards = new RoundCards();
    Table table = new Table(players, deck, roundCards);
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
        int choice = chooseGameMode();
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
        table.dealCards();
        setRandomPlayerWinnerStatus();
        while(!gameOver()) {
            table.dealCardsOnTheTable();
            Player roundWinner = getWinnerOfLastRound();
            int roundWinnerIndex = getWinnerOfLastRoundIndex();
            showWhoHasWonTheRound(roundWinnerIndex);
            showWinnerCard(roundWinnerIndex);
            int playerChoice = getPlayerStatisticChoice(roundWinner);
            chooseStatisticToCompare(playerChoice);
            System.out.println(table.tableToString());
            int winnerIndex = getIndexOfMaxiumumElement();
            switchPlayerWinnerStatus(winnerIndex);
            addCardsToPlayersDeck();
            clearListOfCardsAndListOfStatistic();
            boolean isOver = gameOver();
        }

    }

    public void showWhoHasWonTheRound(int lastRoundWinner) {
        String playerName = players.getPlayer(lastRoundWinner).getName();
        if(!afterFirstRound) {
            System.out.println(playerName + " start the round!");
            afterFirstRound = true;
        }
        else {
            System.out.println(playerName + " has won the round!");
        }
        System.out.println(playerName + " card:");
    }

    public int getWinnerOfLastRoundIndex() {
        int lastRoundWinner = 0;
        for(int i = 0; i < players.getNumberOfPlayers(); i++) {
            if(players.getPlayer(i).isRoundWinner()) {
                lastRoundWinner = i;
            }
        }
        return lastRoundWinner;

    }

    public void showWinnerCard(int winnerIndex) {
        Card card = roundCards.getCard(winnerIndex);
        System.out.println(table.cardToString(card));
    }

    public void setRandomPlayerWinnerStatus() {
        int randomPlayer = rand.nextInt(players.getNumberOfPlayers());
        players.getPlayer(randomPlayer).setRoundWinner();
    }

    public Player getWinnerOfLastRound() {
        Player winner = null;
        for(int i = 0; i < players.getNumberOfPlayers(); i++) {
            if(players.getPlayer(i).isRoundWinner()) {
                winner = players.getPlayer(i);
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
        Player winner = players.getPlayer(winnerIndex);
        return winner;
    }


    public void switchPlayerWinnerStatus(int winnerIndex) {
        for(int i = 0; i < players.getNumberOfPlayers(); i++) {
            if(i == winnerIndex) {
                players.getPlayer(i).setRoundWinner();
            }else {
                players.getPlayer(i).setRoundLooser();
            }
        }
    }

    public void addCardsToPlayersDeck() {
        Player player = getRoundWinnerPlayer();
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            player.getHand().addCardToHand(roundCards.getCard(i));
        }
    }

    public void clearListOfCardsAndListOfStatistic() {
        roundCards.getCards().clear();
        table.getCardsStatistic().clear();
    }

    public void compareTopSpeed() {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getTopSpeed());
        }
    }

    public void compareMaxLength() {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getMaxLength());
        }
    }

    public void compareMaxWeigth() {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getMaxWeight());
        }
    }

    public void compareFood() {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getFood());
        }
    }

    public void compareLifeSpan() {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getLifeSpan());
        }
    }

    private int chooseGameMode() {
        System.out.println("Please choose game mode: ");
        for(GameMode value : values) {
            System.out.println(value);
        }
        System.out.println("Write number: ");
        int choice = getChoice();
        return choice;
    }

    private int chooseNumberOfPlayers() {
        System.out.print("Please choose number of players - 2, 3 or 4: ");
        int numberOfPlayers = getChoice();
        return numberOfPlayers;
    }

    private void createPlayerVsPlayerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            players.addPlayer(createHumanPlayer());
        }
    }

    private void createPlayerVsComputerMode(int numberOfPlayers) {
        int numberOfHumanPlayers = 1;
        players.addPlayer(createHumanPlayer());
        for(int i = 0; i < numberOfPlayers - numberOfHumanPlayers; i++) {
            players.addPlayer(createComputerPlayer("Computer " + i));
        }
    }

    private void createComputerVsComputerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            players.addPlayer(createComputerPlayer("Computer " + i));
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
        for(int i = 0; i < players.getNumberOfPlayers(); i++) {
            int playerCardsAmount = players.getPlayer(i).getHand().getCardsAmount();
            if(playerCardsAmount == 0) {
                return true;
            }
        }
        return false;
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
