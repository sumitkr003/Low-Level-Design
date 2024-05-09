package snakeLadder.gameTile;

import snakeLadder.Pawn;

public class GameTile {
    private Pawn pawn;
    private TileType tileType;

    public GameTile(TileType tileType) {
        this.tileType = tileType;
    }

    public void assignPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public void deAssignPawn() {
        this.pawn = null;
    }

    public TileType getTileType() {
        return this.tileType;
    }
}
