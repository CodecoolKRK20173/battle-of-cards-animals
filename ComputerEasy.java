import java.util.Random;
import java.util.concurrent.TimeUnit;


public class ComputerEasy extends ComputerPlayer {

    Random rand = new Random();

    public ComputerEasy(String name) {
        super(name);
    }


    @Override
    public int makeMove() {
        System.out.println("Player " + getName() + " make move!");
        int choiceShift = 1;
        int randomNumber = rand.nextInt(5);
        int playerChoice = randomNumber + choiceShift;
        return playerChoice;
    }


    // public void switchPlayers() {
    //     System.out.println("You have 2 seconds to switch players!");
    //     try{
    //         TimeUnit.SECONDS.sleep(2);
    //     }
    //     catch(InterruptedException ex){
    //         Thread.currentThread().interrupt();
    //     }
    // }

}
