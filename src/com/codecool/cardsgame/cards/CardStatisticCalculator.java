package com.codecool.cardsgame.cards;

import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.iterator.*;
import com.codecool.cardsgame.players.*;
import java.util.ArrayList;

public class CardStatisticCalculator {


    private Table table;
    private RoundCards roundCards;


    public CardStatisticCalculator(Table table) {
        this.table = table;
        this.roundCards = table.getRoundCards();
    }


    public void compareTopSpeed(Table table) {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getTopSpeed());
        }
    }

    public void compareMaxLength(Table table) {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getMaxLength());
        }
    }

    public void compareMaxWeigth(Table table) {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getMaxWeight());
        }
    }

    public void compareFood(Table table) {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getFood());
        }
    }

    public void compareLifeSpan(Table table) {
        for(int i = 0; i < roundCards.getNumberOfCards(); i++) {
            table.getCardsStatistic().add(roundCards.getCard(i).getLifeSpan());
        }
    }


}
