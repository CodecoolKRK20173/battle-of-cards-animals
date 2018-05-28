public class Cats extends Family {

    private ArrayList<Card> family;

    public Cats() {
        family.add(new Card("Jaguar", 40, 1.9, 120, 10, 20));
        family.add(new Card("Lion", 60, 2.5, 250, 20, 20));
        family.add(new Card("Leopard", 60, 1.9, 91, 8, 21));
        family.add(new Card("Toger", 50, 3, 320, 40, 26));
    }

    public ArrayList<Card> getFamily() {
        return family;
    }


}
