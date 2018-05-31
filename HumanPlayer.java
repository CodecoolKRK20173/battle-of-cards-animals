import java.util.*;
public class HumanPlayer extends Player {

    Scanner scanner = new Scanner(System.in);
    Display display = new Display();


    public HumanPlayer(String name) {
        super(name);
    }


    @Override
    public int makeMove() {
        System.out.println("Player " + getName() + " make move!");
        System.out.println("Choose statistic to compare: ");
        display.displayCardStatistic();
        int playerChoice = scanner.nextInt();
        return playerChoice;
    }

}
