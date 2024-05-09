package chess.pieces;

import chess.Player;
import chess.Tile;

public class Pawn extends Piece{

    public Pawn(Player player) {
        this.player = player;
        this.pieceType = PieceType.PAWN;
        this.pieceName = (player.isWhite() ? "W" : "B") + PieceType.PAWN.identifier;
        this.isFirstMove = false;
    }

    @Override
    public boolean validateMove(Tile sourceTile, Tile targetTile) {
        if(isFirstMove && (sourceTile.x + 2 == targetTile.x && sourceTile.y == targetTile.y)) {
            return true;
        }
        if(sourceTile.y == targetTile.y || sourceTile.x + 1 == targetTile.x) {
            return true;
        }
        return false;
    }
}
