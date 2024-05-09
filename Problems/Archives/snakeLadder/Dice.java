package snakeLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    private List<Integer> rollHistory;
    private Random random;
    private Integer noOfDice;

    public Dice(Integer noOfDice) {
        this.noOfDice = noOfDice;
        this.rollHistory = new ArrayList<>();
        this.random = new Random();
    }
    public Integer roll() {
        Integer res = noOfDice + random.nextInt(6 * noOfDice);
//        rollHistory.add(res);
        return res;
    }
}
