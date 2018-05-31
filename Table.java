import java.util.*;
public class Table {

    private Deck deck = new Deck();
    private ArrayList<Card> cards;
    private ArrayList<Player> players;
    private ArrayList<Card> cardsPutted;
    private int cardWidth;


    public Table() {
        cards = deck.getAllCards();
        players = new ArrayList<Player>();
        cardsPutted = new ArrayList<Card>();
        this.cardWidth = 29;
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
        for(Card card : cardsPutted) {
            listsOfCardsParts.get(2).add(space+center(repeat(line))+space);
            listsOfCardsParts.get(3).add(frame+center(card.getName())+frame);
            listsOfCardsParts.get(4).add(frame+center(repeat(line))+frame);
            listsOfCardsParts.get(5).add(frame+center("Top speed:  " + card.getTopSpeed()+ " kph   ")+ frame);
            listsOfCardsParts.get(6).add(frame+center("Max.length: " + card.getMaxLength()+ " m     ")+ frame);
            listsOfCardsParts.get(7).add(frame+center("Max.weight:  " + card.getMaxWeight()+ " kg    ")+ frame);
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
