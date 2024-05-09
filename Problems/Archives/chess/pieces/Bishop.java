package chess.pieces;

import chess.Player;
import chess.Tile;

public class Bishop extends Piece{

    public Bishop(Player player) {
        this.player = player;
        this.pieceType = PieceType.BISHOP;
        this.pieceName = (player.isWhite() ? "W" : "B") + PieceType.BISHOP.identifier;
    }

    @Override
    public boolean validateMove(Tile sourceTile, Tile targetTile) {
        return Math.abs(targetTile.x - sourceTile.x) == Math.abs(targetTile.y - sourceTile.y);
    }
}
