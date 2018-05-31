

public class ComputerHard extends ComputerPlayer {


    public ComputerHard(String name) {
        super(name);
    }


    @Override
    public int makeMove() {
        return 1000;
    }


}
