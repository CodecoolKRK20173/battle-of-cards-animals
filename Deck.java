import java.util.*;

public class Deck implements Comparable<Card>{
    private ArrayList<deck> deck;
    private int[] speeds = new int[32];
    private int[] lengths = new int[32];
    private int[] weights = new int[32];
    private int[] foods = new int[32];
    private int[] lifeSpans = new int[32];
    private String[] names = new String[32];

    public Deck() {
        deck.add(new Card("Jaguar", 40, 1.9, 120, 10, 20));
        deck.add(new Card("Lion", 60, 2.5, 250, 20, 20));
        deck.add(new Card("Leopard", 60, 1.9, 91, 8, 21));
        deck.add(new Card("Toger", 50, 3, 320, 40, 26));
        deck.add(new Card("lar gibbon", 55, 0.6, 7, 1, 40));
        deck.add(new Card("Chimpanzee", 24, 1.2, 70, 6, 60));
        deck.add(new Card("Orang-utan", 20, 1.4, 90, 12, 50));
        deck.add(new Card("Western gorilla", 22, 1.7, 180, 22, 50));
        deck.add(new Card("Brown bear", 40, 3, 780, 20, 46));
        deck.add(new Card("Polar bear", 55, 3.4, 800, 50, 41));
        deck.add(new Card("Sloth bear", 20, 1.8, 150, 6, 40));
        deck.add(new Card("American black bear", 48, 1.9, 270, 10, 32));
        deck.add(new Card("Red fox", 40, 0.9, 11, 1, 14));
        deck.add(new Card("Arctic fox", 40, 0.6, 8, 0.75, 12));
        deck.add(new Card("Grey wolf", 70, 1.5, 80, 10, 20));
        deck.add(new Card("African wild dog", 56, 1.1, 36, 4.5, 12));
        deck.add(new Card("Asian elephant", 24, 1.5, 5600, 150, 75));
        deck.add(new Card("African elephant", 40, 5, 7000, 275, 70));
        deck.add(new Card("Hippopotamus", 0, 2.7, 1500, 60, 50));
        deck.add(new Card("Pygmy hippopotamus", 0, 1.6, 275, 25, 45));
        deck.add(new Card("Red kangaroo", 63, 1.6, 40, 6, 20));
        deck.add(new Card("Koala", 6, 0.8, 15, 0.5, 18));
        deck.add(new Card("Duck-biffed platypus", 10, 0.6, 3, 1, 17));
        deck.add(new Card("Short nosed echidna", 6, 0.45, 7, 15, 65));
        deck.add(new Card("Moose / Elk", 54, 3.5, 700, 30, 20));
        deck.add(new Card("Giraffe", 56, 5.3, 1500, 34, 30));
        deck.add(new Card("Bongo", 36, 2.5, 400, 14, 19));
        deck.add(new Card("Musk ox", 45, 2.3, 410, 6, 24));
        deck.add(new Card("Blue whale", 48, 30, 140000, 3000, 80));
        deck.add(new Card("Bowhead whale", 20, 14, 80000, 1500, 100));
        deck.add(new Card("Gray whale", 10, 15, 34000, 1250, 70));
        deck.add(new Card("Minkle whale", 34, 9.2, 10000, 500, 60));
        getSpecifications();
    }

    public ArrayList<deck> getDeck() {
        return deck;
    }

    public float compareTo(Card compareCard) {

		float compareValue = ((Card) compareCard).getValue();

		//ascending order
		return this.value - compareValue;

		//descending order
		//return compareQuantity - this.quantity;

	}

	public static Comparator<Card> FruitNameComparator = new Comparator<Card>() {

	    public int compare(Card fruit1, Card fruit2) {

	      String fruitName1 = fruit1.getFruitName().toUpperCase();
	      String fruitName2 = fruit2.getFruitName().toUpperCase();

	      //ascending order
	      return fruitName1.compareTo(fruitName2);

	      //descending order
	      //return fruitName2.compareTo(fruitName1);
	    }
    }

    public void getSpecifications() {
        int i = 0;
        for (Card card : deck) {
            speeds[i] = card.getTopSpeed();
            lengths[i] = card.getMaxLength();
            weights[i] = card.getMaxWeight();
            foods[i] = card.getFood();
            lifeSpans[i] = card.getLifeSpan();
            i++;
        }
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public void mixCards() {
        Collections.shuffle(deck);
    }

    // public void dealCards(ArrayList<Player> players) {
    //     for (Player player : players) {
    //
    //     }
    // }
}
