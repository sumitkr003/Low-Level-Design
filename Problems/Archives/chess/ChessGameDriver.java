package chess;

import java.util.Scanner;

public class ChessGameDriver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ChessGame chessGame = new ChessGame();
        Player whitePlayer = new Player("Player A", true);
        Player blackPlayer = new Player("Player B", false);
        chessGame.initialiseGame(blackPlayer, whitePlayer, 8);
        while(true) {
            String command = in.nextLine();
            try {
                System.out.println(command);
                if(command.equalsIgnoreCase("exit")) {
                    return;
                }
                chessGame.makeMove(command.split(" ")[0], command.split(" ")[1]);
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

//e2 e4
//e7 e5
//f1 c4
//b8 c6
//d1 h5
//g8 f6
//h5 f7
//f8 f7
//g7 f7
//h8 f7
//d8 f7
//c6 f7
//c4 f7
//h8 g8
//f2 f4
//e5 f4
//a7 a6
//f7 e8
//exit