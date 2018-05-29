import java.util.*;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();
    private double[] speeds = new double[32];
    private double[] lengths = new double[32];
    private double[] weights = new double[32];
    private double[] foods = new double[32];
    private double[] lifeSpans = new double[32];
    private String[] names = new String[32];

    public Deck() {
        cards.add(new Card("Jaguar", 40, 1.9, 120, 10, 20));
        cards.add(new Card("Lion", 60, 2.5, 250, 20, 20));
        cards.add(new Card("Leopard", 60, 1.9, 91, 8, 21));
        cards.add(new Card("Toger", 50, 3, 320, 40, 26));
        cards.add(new Card("lar gibbon", 55, 0.6, 7, 1, 40));
        cards.add(new Card("Chimpanzee", 24, 1.2, 70, 6, 60));
        cards.add(new Card("Orang-utan", 20, 1.4, 90, 12, 50));
        cards.add(new Card("Western gorilla", 22, 1.7, 180, 22, 50));
        cards.add(new Card("Brown bear", 40, 3, 780, 20, 46));
        cards.add(new Card("Polar bear", 55, 3.4, 800, 50, 41));
        cards.add(new Card("Sloth bear", 20, 1.8, 150, 6, 40));
        cards.add(new Card("American black bear", 48, 1.9, 270, 10, 32));
        cards.add(new Card("Red fox", 40, 0.9, 11, 1, 14));
        cards.add(new Card("Arctic fox", 40, 0.6, 8, 0.75, 12));
        cards.add(new Card("Grey wolf", 70, 1.5, 80, 10, 20));
        cards.add(new Card("African wild dog", 56, 1.1, 36, 4.5, 12));
        cards.add(new Card("Asian elephant", 24, 1.5, 5600, 150, 75));
        cards.add(new Card("African elephant", 40, 5, 7000, 275, 70));
        cards.add(new Card("Hippopotamus", 0, 2.7, 1500, 60, 50));
        cards.add(new Card("Pygmy hippopotamus", 0, 1.6, 275, 25, 45));
        cards.add(new Card("Red kangaroo", 63, 1.6, 40, 6, 20));
        cards.add(new Card("Koala", 6, 0.8, 15, 0.5, 18));
        cards.add(new Card("Duck-biffed platypus", 10, 0.6, 3, 1, 17));
        cards.add(new Card("Short nosed echidna", 6, 0.45, 7, 15, 65));
        cards.add(new Card("Moose / Elk", 54, 3.5, 700, 30, 20));
        cards.add(new Card("Giraffe", 56, 5.3, 1500, 34, 30));
        cards.add(new Card("Bongo", 36, 2.5, 400, 14, 19));
        cards.add(new Card("Musk ox", 45, 2.3, 410, 6, 24));
        cards.add(new Card("Blue whale", 48, 30, 140000, 3000, 80));
        cards.add(new Card("Bowhead whale", 20, 14, 80000, 1500, 100));
        cards.add(new Card("Gray whale", 10, 15, 34000, 1250, 70));
        cards.add(new Card("Minkle whale", 34, 9.2, 10000, 500, 60));
        getSpecifications();
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
