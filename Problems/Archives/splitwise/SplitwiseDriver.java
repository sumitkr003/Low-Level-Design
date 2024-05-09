package splitwise;

import java.util.Scanner;

public class SplitwiseDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SplitwiseSystem system = new SplitwiseSystem();

        while(true) {
            String line = in.nextLine();
            if(line == null || line.length() == 0) {
                return;
            }
            String[] operands = line.split(" ");
            SplitwiseOperations operation = SplitwiseOperations.getSplitwiseOperation(operands[0]);
            switch (operation) {
                case EXPENSE:
                    system.processRawExpenseInput(operands);
                    break;
                case SHOW:
                    if(operands.length == 1) {
                        system.display();
                    } else {
                        system.displayForUser(operands[1]);
                    }
                    break;
            }
        }
    }
}

//SHOW
//SHOW u1
//EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL
//SHOW u4
//SHOW u1
//EXPENSE u1 1250 2 u2 u3 EXACT 370 880
//SHOW
//EXPENSE u4 1200 4 u1 u2 u3 u4 PERCENT 40 20 20 20
//SHOW u1
//SHOW