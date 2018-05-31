import java.util.*;
public class Card {

    private String name;
    private double topSpeed;
    private double maxLength;
    private double maxWeight;
    private double food;
    private double lifeSpan;
    private int cardWidth;

    public Card(String name, double topSpeed, double maxLength, double maxWeight, double food, double lifeSpan) {
        this.name = name;
        this.topSpeed = topSpeed;
        this.maxLength = maxLength;
        this.maxWeight = maxWeight;
        this.food = food;
        this.lifeSpan = lifeSpan;
        this.cardWidth = 22;
    }

    public String getName() {
        return name;
    }
    public double getTopSpeed() {
        return topSpeed;
    }

    public double getMaxLength() {
        return maxLength;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public double getFood() {
        return food;
    }

    public double getLifeSpan() {
        return lifeSpan;
    }
}
