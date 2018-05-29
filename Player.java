import java.util.*;
public abstract class Player {

    private String name;
    private Hand hand;
    private boolean roundWinner;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.roundWinner = false;
    }

    // public Player(String name, Hand hand) {
    //     this.name = name;
    //     this.hand = hand;
    // }



    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public abstract String makeMove();

    // public abstract int chooseStatisticToCompare();

}
