public class Ungulates extends Family {

    private ArrayList<Card> family;

    public Ungulates() {
        family.add(new Card("Moose / Elk", 54, 3.5, 700, 30, 20));
        family.add(new Card("Giraffe", 56, 5.3, 1500, 34, 30));
        family.add(new Card("Bongo", 36, 2.5, 400, 14, 19));
        family.add(new Card("Musk ox", 45, 2.3, 410, 6, 24));
    }

    public ArrayList<Card> getFamily() {
        return family;
    }

    public Card getCard(int index) {
        return family.get(index);
    }


}
