

public class ComputerPlayer extends Player {


    public ComputerPlayer(String name) {
        super(name);
    }


    public getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public abstract Card void makeMove() {
        return hand.getCards().getCard(0);
    }
}
