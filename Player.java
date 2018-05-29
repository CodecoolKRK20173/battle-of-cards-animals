

public abstract class Player {

    private String name;
    private int numberOfCards;
    

    public Player(String name, int numberOfCards) {
        this.name = name;
        this.numberOfCards = numberOfCards;
    }


    public String getName() {
        return name;
    }

    
    public int getNumberOfCards() {
        return numberOfCards;
    }


    public abstract void makeMove();

    public abstract int chooseStatisticToCompare();


}