public class ElephantsHippos extends Family {

    private ArrayList<Card> family;

    public ElephantsHippos() {
        family.add(new Card("Asian elephant", 24, 1.5, 5600, 150, 75));
        family.add(new Card("African elephant", 40, 5, 7000, 275, 70));
        family.add(new Card("Hippopotamus", 0, 2.7, 1500, 60, 50));
        family.add(new Card("Pygmy hippopotamus", 0, 1.6, 275, 25, 45));
    }

    public ArrayList<Card> getFamily() {
        return family;
    }

    public Card getCard(int index) {
        return family.get(index);
    }


}
