package chess;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class ChessBoard {
    int size;
    Tile[][] tiles;

    public ChessBoard(int size) {
        this.size = size;
        tiles = new Tile[size][size];
        for(int i = 0; i<size; i++) {
            for(int j = 0; j< size; j++) {
                tiles[i][j] = new Tile(i, j);
            }
        }
    }

    public Tile getTile(Integer y, Integer x) throws Exception {
        if(x<0 || x>size || y<0 || y>size) {
            throw new Exception("Invalid Coordinated Provided");
        }
        return tiles[x-1][y];
    }

    public void initializeBoard(Player whitePlayer, Player blackPlayer) {
        initializePlayerPawns(whitePlayer);
        initializePlayerPawns(blackPlayer);
        initializePlayerRookKnightBishop(whitePlayer);
        initializePlayerRookKnightBishop(blackPlayer);
        initializePlayerKingQueen(whitePlayer);
        initializePlayerKingQueen(blackPlayer);
    }

    private void initializePlayerPawns(Player player) {
        int row = player.white ? 1 : 6;
        for(int col = 0; col<size; col++) {
            Pawn pawn = new Pawn(player);
            tiles[row][col].assignPiece(pawn);
        }
    }

    private void initializePlayerRookKnightBishop(Player player) {
        int row = player.white ? 0 : 7;

        Rook lr = new Rook(player);
        tiles[row][0].assignPiece(lr);
        Rook rr = new Rook(player);
        tiles[row][7].assignPiece(rr);

        Knight lk = new Knight(player);
        tiles[row][1].assignPiece(lk);
        Knight rk = new Knight(player);
        tiles[row][6].assignPiece(rk);

        Bishop lb = new Bishop(player);
        tiles[row][2].assignPiece(lb);
        Bishop rb = new Bishop(player);
        tiles[row][5].assignPiece(rb);
    }

    private void initializePlayerKingQueen(Player player) {
        int row = player.white ? 0 : 7;

        Queen queen = new Queen(player);
        tiles[row][3].assignPiece(queen);
        King king = new King(player);
        tiles[row][4].assignPiece(king);
    }

    public void display() {
        for(int i = size-1; i>=0; i--) {
            for(int j = 0; j<size; j++) {
                System.out.print(tiles[i][j].piece == null ? " -- " : " " +tiles[i][j].piece.getPieceName() + " ");
            }
            System.out.println();
        }
    }
}
