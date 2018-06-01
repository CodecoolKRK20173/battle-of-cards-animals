package com.codecool.cardsgame.cards;

import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.iterator.*;
import com.codecool.cardsgame.players.*;
import java.util.*;


public class Hand {
    private ArrayList<Card> holdedCards;

    public Hand() {
        holdedCards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return holdedCards;
    }

    public void addCardToHand(Card card) {
        holdedCards.add(card);
    }

    public int getCardsAmount() {
        return holdedCards.size();
    }

    public Card getCard(int index) {
        return holdedCards.get(index);
    }

    public boolean hasCard() {
        if(holdedCards.size() > 0) {
            return true;
        }
        return false;
    }
}
