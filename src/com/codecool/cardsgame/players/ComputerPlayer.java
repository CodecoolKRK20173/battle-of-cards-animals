package com.codecool.cardsgame.players;

import com.codecool.cardsgame.cards.*;
import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.iterator.*;
import java.util.*;



public class ComputerPlayer extends Player {

    Random rand = new Random();

    public ComputerPlayer(String name) {
        super(name);
    }


    @Override
    public int makeMove() {
        System.out.println("Player " + getName() + " make move!");
        int choiceShift = 1;
        int randomNumber = rand.nextInt(5);
        int playerChoice = randomNumber + choiceShift;
        return playerChoice;
    }

}
