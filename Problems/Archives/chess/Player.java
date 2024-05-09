package chess;

public class Player {
    boolean white;
    String playerName;

    public Player(String name, boolean white) {
        this.playerName = name;
        this.white = white;
    }
    public boolean isWhite() {
        return white;
    }
}
