package snakeLadder.gameTile;

public class LadderTile extends GameTile{

    private Integer startPos;
    private Integer endPos;

    public LadderTile(TileType tileType, Integer start, Integer end) {
        super(tileType);
        this.startPos = start;
        this.endPos = end;
    }

    public Integer getEndPos() {
        return this.endPos;
    }
}
