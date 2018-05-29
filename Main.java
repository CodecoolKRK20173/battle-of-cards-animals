import java.util.*;

public class Main {


    public static void main(String[] args) {

        // private static GameHandler handler = new GameHandler();

        Table table = new Table();
        table.addPlayer(new HumanPlayer("Ewelina"));
        table.addPlayer(new HumanPlayer("Damian"));
        table.dealCards();

        ArrayList<Player> players = table.getPlayers();
        for (Player player : players) {
            for (Card card : player.getHand().getCards()) {
                System.out.println(card.getName());
            }
            System.out.println("-------------------------");
        }

    }


}
