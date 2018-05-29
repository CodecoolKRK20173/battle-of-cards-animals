import java.util.*;
import java.io.*;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private double[] speeds = new double[32];
    private double[] lengths = new double[32];
    private double[] weights = new double[32];
    private double[] foods = new double[32];
    private double[] lifeSpans = new double[32];
    private String[] names = new String[32];

    public Deck() {
        getCardsFromFile("Cards.csv");
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

    // public double compareTo(Card compareCard) {
    //
	// 	double compareValue = ((Card) compareCard).getValue();
    //
	// 	//ascending order
	// 	return this.value - compareValue;
    //
	// 	//descending order
	// 	//return compareQuantity - this.quantity;
    //
	// }
    //
	// public static Comparator<Card> FruitNameComparator = new Comparator<Card>() {
    //
	//     public int compare(Card fruit1, Card fruit2) {
    //
	//       String fruitName1 = fruit1.getFruitName().toUpperCase();
	//       String fruitName2 = fruit2.getFruitName().toUpperCase();
    //
	//       //ascending order
	//       return fruitName1.compareTo(fruitName2);
    //
	//       //descending order
	//       //return fruitName2.compareTo(fruitName1);
	//     }
    // }

    public void getSpecifications() {
        int i = 0;
        for (Card card : cards) {
            speeds[i] = card.getTopSpeed();
            lengths[i] = card.getMaxLength();
            weights[i] = card.getMaxWeight();
            foods[i] = card.getFood();
            lifeSpans[i] = card.getLifeSpan();
            i++;
        }
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public void mixCards() {
        Collections.shuffle(cards);
    }

    // public void dealCards(ArrayList<Player> players) {
    //     for (Player player : players) {
    //
    //     }
    // }
}
