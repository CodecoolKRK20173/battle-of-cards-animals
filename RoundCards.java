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
