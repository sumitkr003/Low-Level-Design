package snakeLadder;

public class Pawn {
    private Player player;
    private Integer position;

    public Pawn() {
        this.position = 0;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void assignToPlayer(Player player) {
        this.player = player;
    }

    public void moveToPosition(Integer nextPosition) {
        this.position = nextPosition;
    }
}
