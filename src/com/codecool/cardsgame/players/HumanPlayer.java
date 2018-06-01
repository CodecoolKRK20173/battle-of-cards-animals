package com.codecool.cardsgame.players;

import com.codecool.cardsgame.cards.*;
import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.iterator.*;
import java.util.*;


public class HumanPlayer extends Player {

    Scanner scanner = new Scanner(System.in);
    Display display = new Display();

    public HumanPlayer(String name) {
        super(name);
    }

    public int makeMove() {
        System.out.println("Player " + getName() + " make move!");
        System.out.println("Choose statistic to compare: ");
        display.displayCardStatistic();
        int playerChoice = getChoice();
        return playerChoice;
    }

    private int getChoice() {
        boolean getNum = false;
        int num = 0;
        while(!getNum) {
            System.out.print("Please write number (1,2,3,4,5):");
            String choice = scanner.nextLine();
            if(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5")) {
                num = Integer.valueOf(choice);
                getNum = true;
            }
        }
        return num;
    }

}
