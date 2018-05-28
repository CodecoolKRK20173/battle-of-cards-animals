public class Bears extends Family{

    private ArrayList<Card> family;

    public Bears() {
        family.add(new Card("Brown bear", 40, 3, 780, 20, 46));
        family.add(new Card("Polar bear", 55, 3.4, 800, 50, 41));
        family.add(new Card("Sloth bear", 20, 1.8, 150, 6, 40));
        family.add(new Card("American black bear", 48, 1.9, 270, 10, 32));
    }

    public ArrayList<Card> getFamily() {
        return family;
    }

    public Card getCard(int index) {
        return family.get(index);
    }


}
