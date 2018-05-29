public class Card {

    private String name;
    private int topSpeed;
    private float maxLength;
    private int maxWeight;
    private float food;
    private int lifeSpan;

    public Card(String name, int topSpeed, int maxLength, int maxWeight, float food, int lifeSpan) {
        this.name = name;
        this.topSpeed = topSpeed;
        this.maxLength = maxLength;
        this.maxWeight = maxWeight;
        this.food = food;
        this.lifeSpan = lifeSpan;
    }

    public getName() {
        return name;
    }
    public getTopSpeed() {
        return topSpeed;
    }

    public getMaxLength() {
        return maxLength;
    }

    public getMaxWeight() {
        return maxWeight;
    }

    public getFood() {
        return food;
    }

    public getLifeSpan() {
    
        return lifeSpan;
    }
}
