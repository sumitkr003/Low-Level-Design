package snakeLadder;

import snakeLadder.gameTile.FinishTile;
import snakeLadder.gameTile.GameTile;
import snakeLadder.gameTile.LadderTile;
import snakeLadder.gameTile.SnakeTile;
import snakeLadder.gameTile.TileType;

public class GameTileFactory {

    public static GameTile createGameTile(TileType tileType, Pawn pawn, Integer startPos, Integer endPos) {
        switch (tileType) {
            case SNAKE:
                return new SnakeTile(tileType, startPos, endPos);
            case LADDER:
                return new LadderTile(tileType, startPos, endPos);
            case FINISH:
                return new FinishTile(tileType);
        }
        return null;
    }
}
