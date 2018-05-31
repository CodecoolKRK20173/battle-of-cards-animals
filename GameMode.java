import java.util.*;
public enum GameMode {
    PLAYER_PLAYER(1,"Player vs Player"), PLAYER_COMPUTER(2,"Player vs Computer"), COMPUTER_COMPUTER(3,"Computer vs Computer");

    int number;
    String descr;

    private GameMode(int number, String descr) {
        this.number = number;
        this.descr = descr;
    }

    public String toString() {
        return number + ". " + descr;
    }
}
