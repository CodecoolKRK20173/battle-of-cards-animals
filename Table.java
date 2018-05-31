import java.util.*;
public class Table {

    private Deck deck = new Deck();
    private ArrayList<Card> cards;
    private ArrayList<Player> players;
    private ArrayList<Card> cardsOnTheTable;
    private ArrayList<Double> cardsStatistic;
    private final int CARD_WIDTH = 29;
    private final String FRAME = "|";
    private final String SPACE = " ";
    private final String LINE = SPACE+center(repeat("-"))+SPACE;

    public Table() {
        cards = deck.getAllCards();
        players = new ArrayList<Player>();
        cardsOnTheTable = new ArrayList<Card>();
        cardsStatistic = new ArrayList<Double>();
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

    public String cardToString(Card card) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(LINE+"\n");
        strBuilder.append(FRAME+center(card.getName())+FRAME+"\n");
        strBuilder.append(LINE+"\n");
        strBuilder.append(FRAME+center("Top speed:  " + card.getTopSpeed()+ " kph   ")+ FRAME+"\n");
        strBuilder.append(FRAME+center("Max.length: " + card.getMaxLength()+ " m     ")+ FRAME+"\n");
        strBuilder.append(FRAME+center("Max.weight:  " + card.getMaxWeight()+ " kg    ")+ FRAME+"\n");
        strBuilder.append(FRAME+center("Food:       " + card.getFood()+ " kg/day")+ FRAME+"\n");
        strBuilder.append(FRAME+center("Life span:  " + card.getLifeSpan()+ " years ")+ FRAME+"\n");
        strBuilder.append(LINE+"\n");
        return strBuilder.toString();
    }

    public String tableToString() {
        StringBuilder strBuilder = new StringBuilder();
        List<ArrayList<String>> listsOfCardsParts = new ArrayList<ArrayList<String>>();
        for(int i=1; i<=11; i++) {
            listsOfCardsParts.add(new ArrayList<String>());
        }
        for(Player player : players) {
            listsOfCardsParts.get(0).add(SPACE+center(player.getName())+SPACE);
            listsOfCardsParts.get(1).add(SPACE+center("Cards: " + player.getHand().getCardsAmount())+SPACE);
        }
        for(Card card : cardsOnTheTable) {
            listsOfCardsParts.get(2).add(LINE);
            listsOfCardsParts.get(3).add(FRAME+center(card.getName())+FRAME);
            listsOfCardsParts.get(4).add(LINE);
            listsOfCardsParts.get(5).add(FRAME+center("Top speed:  " + card.getTopSpeed()+ " kph   ")+ FRAME);
            listsOfCardsParts.get(6).add(FRAME+center("Max.length: " + card.getMaxLength()+ " m     ")+ FRAME);
            listsOfCardsParts.get(7).add(FRAME+center("Max.weight:  " + card.getMaxWeight()+ " kg    ")+ FRAME);
            listsOfCardsParts.get(8).add(FRAME+center("Food:       " + card.getFood()+ " kg/day")+ FRAME);
            listsOfCardsParts.get(9).add(FRAME+center("Life span:  " + card.getLifeSpan()+ " years ")+ FRAME);
            listsOfCardsParts.get(10).add(LINE);
        }
        for(ArrayList<String> list : listsOfCardsParts) {
            strBuilder.append(String.join(SPACE+SPACE, list)+"\n");
        }
        return strBuilder.toString();
    }

    public String center(String string) {
        int padSize = CARD_WIDTH - string.length();
        int padStart = string.length() + padSize / 2;
        string = String.format("%" + padStart + "s", string);
        string = String.format("%-" + CARD_WIDTH  + "s", string);

        return string;
    }

    public String repeat(String string) {
        return new String(new char[CARD_WIDTH]).replace("\0", string);
    }
}
