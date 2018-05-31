import java.util.*;

public class Main {


    public static void main(String[] args) {

        // private static GameHandler handler = new GameHandler();

        Table table = new Table();

        table.dealCards();

        ArrayList<Player> players = table.getPlayers();
        

        System.out.println(table.tableToString());


    }


}
