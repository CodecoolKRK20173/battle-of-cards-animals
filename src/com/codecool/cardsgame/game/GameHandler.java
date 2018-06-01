package com.codecool.cardsgame.game;

import com.codecool.cardsgame.cards.*;
import com.codecool.cardsgame.iterator.*;
import com.codecool.cardsgame.players.*;
import java.util.*;
import java.io.IOException;

public class GameHandler {

    private Scanner reader = new Scanner(System.in);
    private int choice;
    private int numberOfHumanPlayers;
    private int numberOfPlayers;
    private boolean afterFirstRound = false;
    private GameMode[] values = GameMode.values();
    private Deck deck = new Deck();
    private Players players = new Players();
    private RoundCards roundCards = new RoundCards();
    private Table table = new Table(players, deck, roundCards);
    private CardStatisticCalculator calculate = new CardStatisticCalculator(table);
    private int playerOneIndex = 0;
    private int playerTwoIndex = 1;
    private int playerThreeIndex = 2;
    private int playerFourIndex = 3;
    Display display = new Display();
    private String fileName = "/home/ewelina/workspace/java/cards/battle-of-cards-animals/src/com/codecool/cardsgame/game/about_the_game.txt";

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    public void runApplication() {
        boolean quit = false;
        while(!quit) {
            display.displayMainMenu();
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

    private int getChoice() {
        boolean getNum = false;
        int num = 0;
        while(!getNum) {
            System.out.print("Please write 1, 2 or 3:");
            String choice = scanner.nextLine();
            if(choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                num = Integer.valueOf(choice);
                getNum = true;
            }
        }
        return num;
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
        showWinnerOfTheGame();
        exitGame();
    }

    private int chooseGameMode() {
        System.out.println("Please choose game mode: ");
        for(GameMode value : values) {
            System.out.println(value);
        }
        int choice = getChoice();
        return choice;
    }

    private int chooseNumberOfPlayers() {
        boolean getNum = false;
        int num = 0;
        while(!getNum) {
            System.out.print("Please choose number of players - 2, 3 or 4: ");
            String choice = scanner.nextLine();
            if(choice.equals("2") || choice.equals("3") || choice.equals("4")) {
                num = Integer.valueOf(choice);
                getNum = true;
            }
        }
        return num;
    }

    private void createPlayerVsPlayerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            players.addPlayer(createHumanPlayer());
        }
    }

    public Player createHumanPlayer() {
        System.out.print("Please enter player name: ");
        String playerName = reader.next();
        System.out.println("Player " + playerName + " created!");
        return new HumanPlayer(playerName);
    }

    private void createPlayerVsComputerMode(int numberOfPlayers) {
        int numberOfHumanPlayers = 1;
        players.addPlayer(createHumanPlayer());
        for(int i = 0; i < numberOfPlayers - numberOfHumanPlayers; i++) {
            players.addPlayer(createComputerPlayer("Computer " + (i + 1)));
            System.out.println("Player " + players.getPlayer(i).getName() + " created!");
        }
    }

    public Player createComputerPlayer(String computerName) {
        return new ComputerPlayer(computerName);
    }

    private void createComputerVsComputerMode(int numberOfPlayers) {
        for(int i = 0; i < numberOfPlayers; i++) {
            players.addPlayer(createComputerPlayer("Computer " + (i + 1)));
            System.out.println("Player " + players.getPlayer(i).getName() + " created!");
        }
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

    public int getWinnerOfLastRoundIndex() {
        int lastRoundWinner = 0;
        for(int i = 0; i < players.getNumberOfPlayers(); i++) {
            if(players.getPlayer(i).isRoundWinner()) {
                lastRoundWinner = i;
            }
        }
        return lastRoundWinner;
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

    public void showWinnerCard(int winnerIndex) {
        Card card = roundCards.getCard(winnerIndex);
        System.out.println(table.cardToString(card));
    }

    public int getPlayerStatisticChoice(Player roundWinner) {
        int playerChoice = roundWinner.makeMove();
        return playerChoice;
    }

    public void chooseStatisticToCompare(int playerChoice) {

        if(playerChoice == 1) {
            calculate.compareTopSpeed(table);
        }
        else if(playerChoice == 2) {
            calculate.compareMaxLength(table);
        }
        else if(playerChoice == 3) {
            calculate.compareMaxWeigth(table);
        }
        else if(playerChoice == 4) {
            calculate.compareFood(table);
        }
        else {
            calculate.compareLifeSpan(table);
        }
    }

    public Double getMaxiumumElement() {
        double maxValue = Collections.max(table.getCardsStatistic());
        return maxValue;
    }

    public boolean playersHaveCards() {
        for(Player p: players.getPlayers()) {
            if(p.getHand().getCardsAmount() == 0){
                return false;
            }
        }
        return true;
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

    public void addCardsFromTableToStack() {
        table.getCardsFromTie().addAll(roundCards.getCards());
        roundCards.getCards().clear();
    }

    public int getIndexOfRoundWinner() {
        double maxValueIndex = getMaxiumumElement();
        int winnerIndex = table.getCardsStatistic().indexOf(maxValueIndex);
        return winnerIndex;
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

    public Player getRoundWinnerPlayer() {
        int winnerIndex = getIndexOfRoundWinner();
        Player winner = players.getPlayer(winnerIndex);
        return winner;
    }

    public void addCardsFromTieCardsListToPlayersDeck() {
        Player player = getRoundWinnerPlayer();
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            player.getHand().addCardToHand(table.getCardsFromTie().get(i));
        }
    }

    public void showWinnerOfTheGame() {
        int lastIndex = players.getPlayers().size() - 1;
        sortPlayersList(players.getPlayers());
        System.out.println(players.getPlayers().get(lastIndex).getName() + " has won the game!");

    }

    public void sortPlayersList(List<Player> toSort) {
        Collections.sort(toSort, new Comparator<Player>() {

            public int compare(Player firstPlayer, Player secondPlayer) {

                int firstPlayerCardsAmount = firstPlayer.getHand().getCardsAmount();
                int secondPlayerCardsAmount = secondPlayer.getHand().getCardsAmount();
                int compareResult = firstPlayerCardsAmount - secondPlayerCardsAmount;

                return compareResult;
            }
        });
    }

    public void clearListOfCardsAndListOfStatistic() {
        roundCards.getCards().clear();
        table.getCardsStatistic().clear();
        table.getCardsFromTie().clear();
    }

    public void clearListOfStatistic() {
        roundCards.getCards().clear();
        table.getCardsStatistic().clear();
    }

    public boolean gameOver() {

        if(players.getNumberOfPlayers() == 2) {
            return gameOverWithTwoPlayers();
        }
        else if (players.getNumberOfPlayers() == 3) {
            return gameOverWithThreePlayers();
        }
        else if (players.getNumberOfPlayers() == 4) {
            return gameOverWithFourPlayers();
        }
        else {
            return false;
        }

    }

    public boolean gameOverWithTwoPlayers () {

        if(players.getPlayer(playerOneIndex).getHand().getCardsAmount() == 0 ||
           players.getPlayer(playerTwoIndex).getHand().getCardsAmount() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean gameOverWithThreePlayers() {

        if(players.getPlayer(playerTwoIndex).getHand().getCardsAmount() == 0 ||
           players.getPlayer(playerThreeIndex).getHand().getCardsAmount() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean gameOverWithFourPlayers() {
        if(players.getPlayer(playerOneIndex).getHand().getCardsAmount() == 0 ||
           players.getPlayer(playerTwoIndex).getHand().getCardsAmount() == 0 ||
           players.getPlayer(playerThreeIndex).getHand().getCardsAmount() == 0 ||
           players.getPlayer(playerFourIndex).getHand().getCardsAmount() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void exitGame() {
        System.exit(0);
    }
}
