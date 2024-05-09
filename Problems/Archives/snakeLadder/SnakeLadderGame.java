package snakeLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SnakeLadderGame {
    private GameBoard gameBoard;
    private List<Player> players;
    private Player turnPlayer;
    private Player winner;
    private Dice dice;
    private Integer turn;

    public SnakeLadderGame(int size) {
        this.gameBoard = new GameBoard(size);
        this.turn = 0;
    }

    public void startGame(List<String> playerNames, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, Integer noOfDices) {
        this.players = initPlayerAndTurns(playerNames);
        this.turnPlayer = players.get(0);
        this.gameBoard.initSnakes(snakes);
        this.gameBoard.initLadders(ladders);
        this.dice = new Dice(noOfDices);
    }

    private List<Player> initPlayerAndTurns(List<String> playerNames) {
        this.players = new ArrayList<>();
        Player prevPlayer = null;
        for(String playerName : playerNames) {
            Pawn pawn = new Pawn();
            Player player = new Player(playerName, pawn);
            pawn.assignToPlayer(player);
            if(prevPlayer != null) {
                prevPlayer.assignNextTurnPlayer(player);
            }
            prevPlayer = player;
            players.add(player);
        }
        players.get(players.size() - 1).assignNextTurnPlayer(players.get(0));
        return players;
    }

    public void makeMove() {
        Integer roll = this.dice.roll();
        Integer afterMovePosition = this.gameBoard.makeMove(roll, turnPlayer);
        if(this.gameBoard.canDecideWinner(afterMovePosition)) {
            this.winner = this.turnPlayer;
            System.out.println("Winner is " + this.turnPlayer.getName());
        }
        this.turnPlayer = this.turnPlayer.getNextTurn();
    }

    public boolean isEnded() {
        return winner != null;
    }
}
