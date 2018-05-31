import java.util.ArrayList;


public abstract class Player {

    private String name;
    private Hand hand;
    private boolean roundWinner;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.roundWinner = false;
    }


    public boolean getRoundWinner() {
        return roundWinner;
    }


    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }


    public void setRoundWinner() {
        roundWinner = true;
    }


    public void setRoundLooser() {
        roundWinner = false;
    }


    public abstract int makeMove();


}
