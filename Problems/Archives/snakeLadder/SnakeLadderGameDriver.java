package snakeLadder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SnakeLadderGameDriver {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int boardSize = Integer.parseInt(in.nextLine());
        int noOfDices = Integer.parseInt(in.nextLine());
        SnakeLadderGame snakeLadderGame = new SnakeLadderGame(boardSize);
        int noOfSnakes = Integer.parseInt(in.nextLine());
        Map<Integer, Integer> snakes = new HashMap<>();
        for(int i = 0; i<noOfSnakes; i++) {
            String input = in.nextLine();
            snakes.put(Integer.parseInt(input.split(" ")[0]), Integer.parseInt(input.split(" ")[1]));
        }
        int noOfLadders = Integer.parseInt(in.nextLine());
        Map<Integer, Integer> ladders = new HashMap<>();
        for(int i = 0; i<noOfLadders; i++) {
            String input = in.nextLine();
            ladders.put(Integer.parseInt(input.split(" ")[0]), Integer.parseInt(input.split(" ")[1]));
        }
        int noOfPlayers = Integer.parseInt(in.nextLine());
        List<String> playerNames = new ArrayList<>();
        for(int i = 0; i<noOfPlayers; i++) {
            playerNames.add(in.nextLine());
        }
        snakeLadderGame.startGame(playerNames, snakes, ladders, noOfDices);
        while(!snakeLadderGame.isEnded()) {
            snakeLadderGame.makeMove();
        }
    }
}

//100
//1
//7
//62 5
//33 6
//49 9
//88 16
//41 20
//56 53
//93 73
//8
//2 37
//27 46
//10 32
//51 68
//61 79
//65 84
//71 91
//81 100
//4
//Gaurav
//Sagar
//Raman
//Vivek