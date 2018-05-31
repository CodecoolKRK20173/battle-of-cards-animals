import java.util.*;
public class ComputerPlayer extends Player {


    public ComputerPlayer(String name) {
        super(name);
    }


    @Override
    public int makeMove() {
        return 1000;
    }
}
