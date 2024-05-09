package snakeLadder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import snakeLadder.gameTile.GameTile;
import snakeLadder.gameTile.LadderTile;
import snakeLadder.gameTile.SnakeTile;
import snakeLadder.gameTile.TileType;

public class GameBoard {
    private Integer size;
    private Map<Integer, GameTile> gameTileMap;

    public GameBoard(int size) {
        this.size = size;
        this.gameTileMap = new HashMap<>();
        this.gameTileMap.put(size, GameTileFactory.createGameTile(TileType.FINISH, null, null, null));
    }

    public int getSize() {
        return this.size;
    }
    public void initSnakes(Map<Integer, Integer> snakes) {
        snakes.forEach((head, tail) -> this.gameTileMap.put(head,
                GameTileFactory.createGameTile(TileType.SNAKE, null, head, tail)));
    }
    public void initLadders(Map<Integer, Integer> ladders) {
        ladders.forEach((start, end) -> this.gameTileMap.put(start,
                GameTileFactory.createGameTile(TileType.LADDER, null, start, end)));
    }

    public Integer makeMove(Integer roll, Player turnPlayer) {
        Pawn turnPlayerPawn = turnPlayer.getPawn();
        Integer currPosition = turnPlayerPawn.getPosition();
        if(currPosition + roll > size) {
            System.out.println("Player " + turnPlayer.getName() + " rolled " + roll + " and stayed at position " + currPosition);
            return -1;
        }
        Integer finalPosition = currPosition + roll;
        while(gameTileMap.containsKey(finalPosition)) {
            GameTile gameTile = gameTileMap.get(finalPosition);
            if(TileType.LADDER == gameTile.getTileType()) {
                finalPosition = ((LadderTile) gameTile).getEndPos();
            }
            else if(TileType.SNAKE == gameTile.getTileType()) {
                finalPosition = ((SnakeTile) gameTile).getEndPos();
            } else if(TileType.FINISH == gameTile.getTileType()) {
                break;
            }
        }
        System.out.println(
                "Player " + turnPlayer.getName() + " rolled " + roll + " and went from position " + currPosition
                        + " to position " + finalPosition);
        turnPlayerPawn.moveToPosition(finalPosition);
        return finalPosition;
    }

    public boolean canDecideWinner(Integer position) {
        return position.intValue() == size.intValue();
    }
}
