package chess.pieces;

import chess.Player;
import chess.Tile;

public class Queen extends Piece{
    public Queen(Player player) {
        this.player = player;
        this.pieceType = PieceType.QUEEN;
        this.pieceName = (player.isWhite() ? "W" : "B") + PieceType.QUEEN.identifier;
    }


    @Override
    public boolean validateMove(Tile sourceTile, Tile targetTile) {
        if(sourceTile.x == targetTile.x || sourceTile.y == targetTile.y) {
            return true;
        }
        if (Math.abs(targetTile.x - sourceTile.x) == Math.abs(targetTile.y - sourceTile.y)) {
            return true;
        }
        return false;
    }
}
