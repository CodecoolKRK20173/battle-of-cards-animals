import java.util.ArrayList;


public abstract class Player {

    private String name;
    private Hand hand;
    private boolean isRoundWinner;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.isRoundWinner = false;
    }

    public boolean isRoundWinner() {
        return isRoundWinner;
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void setRoundWinner() {
        isRoundWinner = true;
    }

    public void setRoundLooser() {
        isRoundWinner = false;
    }

    public abstract int makeMove();


}
