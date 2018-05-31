import java.util.*;
public enum GameMode {
    SMALL(1,"Two players"), MEDIUM(2,"Three players"), LARGE(3,"Four players");

    int number;
    String descr;

    private GameMode(int number, String descr) {
        this.number = number;
        this.descr = descr;
    }

    public String toString() {
        return number + ") " + descr;
    }

    public void loadGame() {
        if (this==SMALL) {
            //
        }
        else if (this==MEDIUM) {
            //
        }
        else if (this==LARGE) {
            //
        }
    }

    public static void main(String[] args) {
        String input = "1";
        int ordinal = Integer.parseInt(input) - 1;
        GameMode[] values = GameMode.values();
        GameMode scale = values[ordinal];

        for(GameMode sc : values) {
            System.out.println(sc);
        }
        scale.loadGame();
    }
}