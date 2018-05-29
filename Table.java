public class Table {

    private Deck deck = new Deck();
    private ArrayList<Card> cards;
    private ArrayList<Player> palyers;

    public Table() {
        players = new ArrayList<Player>();
        cards = deck.getCards();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void dealCards() {
        cards.mixCards();
        int i = 0;
        while(cards.size()>0) {
            for(Player player : players) {
                player.getCards.addCardToHand(cards.get(i));
                i++;
            }
        }

        Iterator iterator = cards.iterator();
            while(iterator.hasNext()) {
                Card card = iterator.next();
            }
        }

    }
}
