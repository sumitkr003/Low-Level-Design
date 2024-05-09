package chess.pieces;


import chess.Player;
import chess.Tile;

public abstract class Piece {
    Player player;
    PieceType pieceType;
    boolean killed;
    String pieceName;
    boolean isFirstMove = false;

    public Player getPlayer() {
        return this.player;
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }

    public void killPiece() {
        this.killed = true;
    }

    public String getPieceName() {
        return this.pieceName;
    }

    public void setIsFirstMove(boolean isFirstMove) {
        this.isFirstMove = isFirstMove;
    }

    public abstract boolean validateMove(Tile sourceTile, Tile targetTile);

}
