public abstract class Player {

    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public abstract getHand();

    public abstract String getName();

    public abstract Card void makeMove();

    public abstract int chooseStatisticToCompare();

}
