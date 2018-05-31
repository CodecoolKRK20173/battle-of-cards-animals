import java.util.*;
public class Table {

    private Deck deck = new Deck();
    private ArrayList<Card> cards;
    private ArrayList<Player> players;
    private ArrayList<Card> cardsOnTheTable;
    private ArrayList<Double> cardsStatistic;



    public Table() {
        players = new ArrayList<Player>();
        cardsOnTheTable = new ArrayList<Card>();
        cardsStatistic = new ArrayList<Double>();
        cards = deck.getAllCards();
    }


    public ArrayList<Player> getPlayers() {
        return players;
    }


    public ArrayList<Card> getCardsOnTheTable() {
        return cardsOnTheTable;
    }


    public ArrayList<Double> getCardsStatistic() {
        return cardsStatistic;
    }


    public void dealCardsOnTheTable() {
        int firstCardIndex = 0;
        for(int i = 0; i < players.size(); i++) {
            Card dealedCard = players.get(i).getHand().getCards().remove(firstCardIndex);
            cardsOnTheTable.add(dealedCard);
        }
    }


    public void addPlayer(Player player) {
        players.add(player);
    }


    public void addCardsToTableList(Card card) {
        cardsOnTheTable.add(card);
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
