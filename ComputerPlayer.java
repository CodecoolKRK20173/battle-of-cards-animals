

public class ComputerPlayer extends Player {


    public ComputerPlayer(String name, int numberOfCards) {
        super(name, numberOfCards);
    }

    public ComputerPlayer(String name) {
        super(name);
    }


    @Override
    public void makeMove() {
        
    }


    @Override
    public int chooseStatisticToCompare() {
        return 100000;
    }



}