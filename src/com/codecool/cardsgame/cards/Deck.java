package com.codecool.cardsgame.cards;

import com.codecool.cardsgame.game.*;
import com.codecool.cardsgame.iterator.*;
import com.codecool.cardsgame.players.*;
import java.util.*;
import java.io.*;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Double> speeds = new ArrayList<>();
    private ArrayList<Double> lengths = new ArrayList<>();
    private ArrayList<Double> weights = new ArrayList<>();
    private ArrayList<Double> foods = new ArrayList<>();
    private ArrayList<Double> lifeSpans = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    public Deck() {
        getCardsFromFile("/home/ewelina/workspace/java/cards/battle-of-cards-animals/src/com/codecool/cardsgame/cards/CardSpecyfications.csv");
    }

    public void getCardsFromFile(String fileName) {
        int nameIndex = 0;
        int speedIndex = 1;
        int lengthIndex = 2;
        int weightIndex = 3;
        int foodIndex = 4;
        int lifeIndex = 5;
        try {
            Scanner sc = new Scanner(new File(fileName));
            while(sc.hasNext()) {
                String[] values = sc.nextLine().split(",");
                String name = values[nameIndex];
                double topSpeed = Double.parseDouble(values[speedIndex]);
                double maxLength = Double.parseDouble(values[lengthIndex]);
                double maxWeight = Double.parseDouble(values[weightIndex]);
                double food = Double.parseDouble(values[foodIndex]);
                double lifeSpan = Double.parseDouble(values[lifeIndex]);
                cards.add(new Card(name, topSpeed, maxLength, maxWeight, food, lifeSpan));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Card> getAllCards() {
        return cards;
    }

    public void getSpecifications() {
        for (Card card : cards) {
            speeds.add(card.getTopSpeed());
            lengths.add(card.getMaxLength());
            weights.add(card.getMaxWeight());
            foods.add(card.getFood());
            lifeSpans.add(card.getLifeSpan());
        }
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public void mixCards() {
        Collections.shuffle(cards);
    }


}
