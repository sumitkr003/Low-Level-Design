package Problems.BattleshipGame.entities;

public class Player {
    private String name;
    private Board board;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void updateBoard(int size) {
        this.board = new Board(size);
    }

    public Board getBoard() {
        return this.board;
    }
}
