import java.util.*;
public class Table {

    private Deck deck = new Deck();
    private ArrayList<Player> players;

    private ArrayList<Card> cards;
    private ArrayList<Card> cardsOnTheTable;
    private ArrayList<Card> cardsFromTie;

    private ArrayList<Double> cardsStatistic;
    private int cardWidth;



    public Table() {
        cards = deck.getAllCards();
        players = new ArrayList<Player>();
        cardsOnTheTable = new ArrayList<Card>();
        cardsFromTie = new ArrayList<Card>();
        cardsStatistic = new ArrayList<Double>();
        this.cardWidth = 29;
    }

    public void clearLists() {
        
        this.cardsStatistic = new ArrayList<>();
    }
    
    public void clearStack() {
        this.cardsFromTie = new ArrayList<>();
        this.cardsOnTheTable = new ArrayList<>();
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


    public ArrayList<Card> getCardsFromTie() {
        return cardsFromTie;
    }


    public void dealCardsOnTheTable() {
        int firstCardIndex = 0;
        for(int i = 0; i < players.size(); i++) {
            Card dealedCard = players.get(i).getHand().getCards().remove(firstCardIndex);
            // Card c = new Card("test", 2d, 2d, 2d, 2d, 2d);
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

    public String tableToString() {
        StringBuilder strBuilder = new StringBuilder();
        List<ArrayList<String>> listsOfCardsParts = new ArrayList<ArrayList<String>>();
        String frame = "|";
        String line = "-";
        String space = " ";
        for(int i=1; i<=11; i++) {
            listsOfCardsParts.add(new ArrayList<String>());
        }
        for(Player player : players) {
            listsOfCardsParts.get(0).add(space+center(player.getName())+space);
            listsOfCardsParts.get(1).add(space+center("Cards: " + player.getHand().getCardsAmount())+space);
        }
        for(Card card : cardsOnTheTable) {
            listsOfCardsParts.get(2).add(space+center(repeat(line))+space);
            listsOfCardsParts.get(3).add(frame+center(card.getName())+frame);
            listsOfCardsParts.get(4).add(frame+center(repeat(line))+frame);
            listsOfCardsParts.get(5).add(frame+center("Top speed:  " + card.getTopSpeed()+ " kph   ")+ frame);
            listsOfCardsParts.get(6).add(frame+center("Max.length: " + card.getMaxLength()+ " m     ")+ frame);
            listsOfCardsParts.get(7).add(frame+center("Max.weight:  " + card.getMaxWeigth()+ " kg    ")+ frame);
            listsOfCardsParts.get(8).add(frame+center("Food:       " + card.getFood()+ " kg/day")+ frame);
            listsOfCardsParts.get(9).add(frame+center("Life span:  " + card.getLifeSpan()+ " years ")+ frame);
            listsOfCardsParts.get(10).add(space+center(repeat(line))+space);
        }
        for(ArrayList<String> list : listsOfCardsParts) {
            strBuilder.append(String.join(space+space, list)+"\n");
        }
        return strBuilder.toString();
    }

    public String center(String string) {
        int padSize = cardWidth - string.length();
        int padStart = string.length() + padSize / 2;
        string = String.format("%" + padStart + "s", string);
        string = String.format("%-" + cardWidth  + "s", string);

        return string;
    }

    public String repeat(String string) {
        return new String(new char[cardWidth]).replace("\0", string);
    }
}
