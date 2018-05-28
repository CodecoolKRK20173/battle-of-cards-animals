public class DogsFoxes extends Family {

    private ArrayList<Card> family;

    public Cats() {
        family.add(new Card("Red fox", 40, 0.9, 11, 1, 14));
        family.add(new Card("Arctic fox", 40, 0.6, 8, 0.75, 12));
        family.add(new Card("Grey wolf", 70, 1.5, 80, 10, 20));
        family.add(new Card("African wild dog", 56, 1.1, 36, 4.5, 12));
    }

    public ArrayList<Card> getFamily() {
        return family;
    }


}
