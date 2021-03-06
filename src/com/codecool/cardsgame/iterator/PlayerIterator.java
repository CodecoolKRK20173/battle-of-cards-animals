package com.codecool.cardsgame.iterator;

import com.codecool.cardsgame.cards.*;
import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.players.*;
import java.util.*;


public class PlayerIterator implements Iterator {
    private ArrayList<Player> players;
    int index;

    public PlayerIterator(ArrayList<Player> players) {
        this.players = players;
    }

    public boolean hasNext() {
        return true;
     }

    public Player next() {
        if(index == players.size()) {
          index = 0;
        }
        return players.get(index++);

     }

}
