package Problems.BattleshipGame;

import java.util.Scanner;

import Problems.BattleshipGame.entities.Player;
import Problems.BattleshipGame.enums.Direction;
import Problems.BattleshipGame.enums.ShipType;
import Problems.BattleshipGame.strategy.DefaultGameStrategy;
import Problems.BattleshipGame.strategy.IGameStrategy;

public class GameEngine {
    Scanner scanner;
    private Player player1;
    private Player player2;
    private IGameStrategy strategy;
    
    public GameEngine() {
        scanner = new Scanner(System.in);
        this.strategy = new DefaultGameStrategy();
    }

    public void setStrategy(IGameStrategy s){
        this.strategy = s;
    }

    private void placeShip(Player player, ShipType.Type shipType) {
        try {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Place Ships for Player: "+ player.getName());
            System.out.println("Placing "+ shipType.toString());

            System.out.println("Enter Direction (D for Down) or (R for right)");
            String dir = scanner.next();
            Direction.Value direction = "D".equals(dir) ? Direction.Value.DOWN : Direction.Value.RIGHT;

            System.out.println("Enter x, y cordinaties");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            player.getBoard().placeShip(x, y, shipType, direction);
            System.out.println(x + " " +y + " " + dir + " " + "D".equals(dir) + " "  + shipType.toString() + " " + direction.toString());
            player.getBoard().printBoard();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        } catch(Exception e){
            System.out.println(e);
            System.out.println("an expection occured, please try placing ship again");
            placeShip(player, shipType);
        }
    }

    private void placeShipForPlayer(Player player){
        placeShip(player, ShipType.Type.Carrier);
        placeShip(player, ShipType.Type.Battleship);
        placeShip(player, ShipType.Type.Cruiser);
        placeShip(player, ShipType.Type.Submarine);
        placeShip(player, ShipType.Type.Destroyer);
    }

    public void intializeGame(){
        System.out.println("Enter Player 1 Name: ");
        String playerName = scanner.nextLine();
        this.player1 = new Player(playerName);

        System.out.println("Enter Player 2 Name: ");
        playerName = scanner.nextLine();
        this.player2 = new Player(playerName);

        System.out.println("Enter Board Size: ");
        int boardSize = scanner.nextInt();

        this.player1.updateBoard(boardSize);
        this.player2.updateBoard(boardSize);

        placeShipForPlayer(this.player1);
        placeShipForPlayer(this.player2);

        try {
            startGame();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    private void startGame() throws Exception{
        if(this.strategy != null){
            this.strategy.startGame(player1, player2);
        }else{
            throw new Exception("Please define a game strategy before starting this game");
        }
    }
}
