package chess.pieces;


public enum PieceType {
    KING("K"),
    QUEEN("Q"),
    ROOK("R"),
    KNIGHT("N"),
    BISHOP("B"),
    PAWN("P");

    String identifier;
    PieceType(String identifier) {
        this.identifier = identifier;
    }
}
