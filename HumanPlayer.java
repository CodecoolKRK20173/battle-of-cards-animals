import java.util.Scanner;



public class HumanPlayer extends Player {

    Scanner scanner = new Scanner(System.in);
    Display display = new Display();

    public HumanPlayer(String name) {
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
    
    public int chooseStatisticToCompare() {

        System.out.print("Choose statistic to compare: ");
        display.displayCardStatistic();
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

}
