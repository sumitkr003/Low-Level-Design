package chess;

import chess.pieces.PieceType;

public class ChessGame {
    Player blackPlayer;
    Player whitePlayer;
    Player turnPlayer;

    ChessBoard chessBoard;
    String winner;

    public void initialiseGame(Player blackPlayer, Player whitePlayer, int size) {
        this.blackPlayer = blackPlayer;
        this.whitePlayer = whitePlayer;
        this.turnPlayer = whitePlayer;
        this.chessBoard = new ChessBoard(8);
        this.chessBoard.initializeBoard(whitePlayer, blackPlayer);
    }

    public void makeMove(String fromPosition, String toPosition) throws Exception {
        System.out.println(this.turnPlayer.playerName + " turn");
        if(winner != null) {
            throw new Exception("Game Is Already Over");
        }
        Tile sourceTile = this.chessBoard.getTile(fromPosition.charAt(0)-'a', fromPosition.charAt(1)-'0');
        Tile targetTile = this.chessBoard.getTile(toPosition.charAt(0)-'a', toPosition.charAt(1)-'0');
        validateMove(sourceTile, targetTile);
        executeMove(sourceTile, targetTile);
        turnPlayer = (turnPlayer.equals(whitePlayer) ? blackPlayer : whitePlayer);
    }

    private void validateMove(Tile sourceTile, Tile targetTile) throws Exception {
        if(sourceTile == null || targetTile == null) {
            throw new Exception("Invalid Tile");
        }
        if(sourceTile.x == targetTile.x && sourceTile.y == targetTile.y) {
            throw new Exception("No Move Made");
        }
        if(sourceTile.piece == null || !sourceTile.piece.getPlayer().equals(turnPlayer)) {
            throw new Exception("Invalid Move");
        }
        boolean isValidMove = (targetTile.piece == null || !targetTile.piece.getPlayer().equals(turnPlayer))
                && sourceTile.piece.validateMove(sourceTile, targetTile);
        if(!isValidMove) {
            throw new Exception("Invalid Move");
        }
    }

    private void executeMove(Tile sourceTile, Tile targetTile) {
        if(targetTile.piece != null) {
            targetTile.piece.killPiece();
            if(PieceType.KING == targetTile.piece.getPieceType()) {
                this.winner = sourceTile.piece.getPlayer().playerName;
                System.out.println("Winner is : " + this.winner);
            }
        }
        targetTile.assignPiece(sourceTile.piece);
        sourceTile.assignPiece(null);
        targetTile.piece.setIsFirstMove(false);
        this.display();
    }

    public void display() {
        this.chessBoard.display();
    }
}
