package com.codecool.cardsgame.players;

import com.codecool.cardsgame.cards.*;
import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.iterator.*;
import java.util.*;


public class Players {

    private ArrayList<Player> players;

    public Players() {
        players = new ArrayList<Player>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
