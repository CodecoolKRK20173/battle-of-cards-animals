

public class ComputerEasy extends ComputerPlayer {


    public ComputerEasy(String name) {
        super(name);
    }


    @Override
    public int makeMove() {
        return 1000;
    }


}
