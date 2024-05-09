package chess.pieces;

import chess.Player;
import chess.Tile;

public class King extends Piece{
    public King(Player player) {
        this.player = player;
        this.pieceType = PieceType.KING;
        this.pieceName = (player.isWhite() ? "W" : "B") + PieceType.KING.identifier;
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
    private int[] dx = {1,-1,1,-1,0,1,0,-1};
    private int[] dy = {1,-1,-1,1,1,0,-1,0};
}
