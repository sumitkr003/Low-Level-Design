package Problems.BattleshipGame.strategy;

import java.util.Scanner;

import Problems.BattleshipGame.entities.Player;

public class RoundRobinStrategy implements IGameStrategy {

    public void startGame(Player player1, Player player2){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game Start: ");
        Player turn = player1;
        while(true){
           try{
            System.out.println(turn.getName() + " turn");
            Player opponent = turn == player1 ? player2 : player1;
            opponent.getBoard().printBoard();

            System.out.println("Enter x & y co-ordinate to throw missile");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            boolean isHit = opponent.getBoard().throwMissile(x, y);
            // even if you hit a ship the turn goes to next player
            if(opponent.getBoard().hasAnyShipRemaining()){
                if(isHit) System.out.println("HIT !!");
                turn = opponent;
            }else{
                System.out.println(turn.getName() + " won !");
                break;
            }
           } catch(Exception e){
            System.out.println(e);
            break;
           }
        }
        scanner.close();
    }
}
