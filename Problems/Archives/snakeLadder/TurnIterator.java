package snakeLadder;

public abstract class TurnIterator {
    protected Player nextTurn;

    public Player getNextTurn() {
        return this.nextTurn;
    }

    public abstract void assignNextTurnPlayer(Player player);
}
