package snakeLadder;

import java.util.UUID;

public class Player extends TurnIterator {
    private String name;
    private String userId;
    private Pawn pawn;

    public String getName() {
        return this.name;
    }

    public Player(String name, Pawn pawn) {
        this.name = name;
        this.userId = UUID.randomUUID().toString();
        this.pawn = pawn;
    }

    @Override
    public void assignNextTurnPlayer(Player player) {
        this.nextTurn = player;
    }

    public Pawn getPawn() {
        return this.pawn;
    }
}
