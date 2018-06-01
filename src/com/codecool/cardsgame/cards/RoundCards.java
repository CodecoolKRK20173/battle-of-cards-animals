package com.codecool.cardsgame.cards;

import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.iterator.*;
import com.codecool.cardsgame.players.*;
import java.util.*;


public class RoundCards {

    private ArrayList<Card> cards;

    public RoundCards() {
        cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
