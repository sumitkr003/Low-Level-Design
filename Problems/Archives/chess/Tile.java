package chess;

import chess.pieces.Piece;

public class Tile {
    public int x;
    public int y;
    Piece piece;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void assignPiece(Piece piece) {
        this.piece = piece;
    }

}
