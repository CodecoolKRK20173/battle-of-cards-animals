public class Whales extends Family {

    private ArrayList<Card> family;

    public Whales() {
        family.add(new Card("Blue whale", 48, 30, 140000, 3000, 80));
        family.add(new Card("Bowhead whale", 20, 14, 80000, 1500, 100));
        family.add(new Card("Gray whale", 10, 15, 34000, 1250, 70));
        family.add(new Card("Minkle whale", 34, 9.2, 10000, 500, 60));
    }

    public ArrayList<Card> getFamily() {
        return family;
    }


}
