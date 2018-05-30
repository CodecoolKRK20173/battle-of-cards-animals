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
        if(holdedCards.size()>0) {
            return true;
        }
        return false;
    }



}