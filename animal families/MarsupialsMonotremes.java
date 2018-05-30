public class MarsupialsMonotremes extends Family {

    private ArrayList<Card> family;

    public Cats() {
        family.add(new Card("Red kangaroo", 63, 1.6, 40, 6, 20));
        family.add(new Card("Koala", 6, 0.8, 15, 0.5, 18));
        family.add(new Card("Duck-biffed platypus", 10, 0.6, 3, 1, 17));
        family.add(new Card("Short nosed echidna", 6, 0.45, 7, 15, 65));
    }

    public ArrayList<Card> getFamily() {
        return famyly;
    }

    public Card getCard(int index) {
        return family.get(index);
    }


}
