package chess.pieces;

import chess.Player;
import chess.Tile;

public class Rook extends Piece{

    public Rook(Player player) {
        this.player = player;
        this.pieceType = PieceType.ROOK;
        this.pieceName = (player.isWhite() ? "W" : "B") + PieceType.ROOK.identifier;
    }

    @Override
    public boolean validateMove(Tile sourceTile, Tile targetTile) {
        return sourceTile.x == targetTile.x || sourceTile.y == targetTile.y;
    }
}
