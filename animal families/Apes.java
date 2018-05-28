public class Apes extends Family {

    private ArrayList<Card> family;

    public Apes() {
        family.add(new Card("lar gibbon", 55, 0.6, 7, 1, 40));
        family.add(new Card("Chimpanzee", 24, 1.2, 70, 6, 60));
        family.add(new Card("Orang-utan", 20, 1.4, 90, 12, 50));
        family.add(new Card("Western gorilla", 22, 1.7, 180, 22, 50));
    }

    public ArrayList<Card> getFamily() {
        return family;
    }

    public Card getCard(int index) {
        return family.get(index);
    }


}
