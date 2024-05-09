package chess.pieces;

import chess.Player;
import chess.Tile;

public class Knight extends Piece{
    public Knight(Player player) {
        this.player = player;
        this.pieceType = PieceType.KNIGHT;
        this.pieceName = (player.isWhite() ? "W" : "B") + PieceType.KNIGHT.identifier;
    }

    @Override
    public boolean validateMove(Tile sourceTile, Tile targetTile) {
        for(int i = 0; i<8; i++) {
            if(targetTile.x == sourceTile.x + dx[i] && targetTile.y == sourceTile.y + dy[i]) {
                return true;
            }
        }
        return false;
    }
    private int[] dx = {1,-1,2,2,1,-1,-2,-2};
    private int[] dy = {2,2,1,-1,-2,-2,1,-1};
}
