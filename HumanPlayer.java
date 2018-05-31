import java.util.*;
public class HumanPlayer extends Player {

    Scanner scanner = new Scanner(System.in);
    Display display = new Display();

    public HumanPlayer(String name) {
        super(name);
    }



    @Override
    public String makeMove() {
        return "";
    }


    // @Override
    // public void chooseStatisticToCompare() {
    //     int cardStatisticIndex = 0;
    //     System.out.print("Choose statistic to compare: ");
    //     display.displayCardStatistic();
    //     int choice = scanner.nextInt();
    //     switch(choice) {
    //         case 1:
    //             compareTopSpeed();
    //             break;
    //         case 2:
    //             compareMaxLength();
    //             break;
    //         case 3:
    //             compareMaxWeigth();
    //             break;
    //         case 4:
    //             compareFood();
    //             break;
    //         case 5:
    //             compareLifeSpan();
    //             break;
    //     }
    // }
}
