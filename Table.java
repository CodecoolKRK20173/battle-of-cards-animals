import java.util.*;
public class Table {

    private Deck deck = new Deck();
    private ArrayList<Card> cards;
    private ArrayList<Player> players;

    public Table() {
        players = new ArrayList<Player>();
        cards = deck.getAllCards();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void dealCards() {
        deck.mixCards();
        Iterator iter = new PlayerIterator(players);
        int i = 0;
        while(i < cards.size()) {
            Player player = (Player) iter.next();
            player.getHand().addCardToHand(cards.get(i));
            i++;
        }
    }
}
