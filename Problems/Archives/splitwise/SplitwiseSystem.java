package splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SplitwiseSystem {
    private HashMap<String, User> userHashMap;

    public SplitwiseSystem() {
        this.userHashMap = new HashMap<>();
    }
    public void processRawExpenseInput(String[] operands) {
        int operand = 1;
        String paidUserId = operands[operand++];
        Double amountPaid = Double.parseDouble(operands[operand++]);
        User paidUser = null;
        if(userHashMap.containsKey(paidUserId)) {
            paidUser = userHashMap.get(paidUserId);
        } else {
            paidUser = new User(paidUserId);
            userHashMap.put(paidUserId, paidUser);
        }

        Integer noOfUsers = Integer.parseInt(operands[operand++]);
        List<String> userIds = new ArrayList<>();
        for(int i = 0; i<noOfUsers; i++) {
            String userId = operands[operand++];
            userIds.add(userId);
            if(!userHashMap.containsKey(userId)) {
                userHashMap.put(userId,  new User(userId));
            }
        }
        List<ExpenseUnit> expenseUnits = new ArrayList<>();
        ExpenseDistributionType expenseDistributionType = ExpenseDistributionType.valueOf(operands[operand++]);
        Expense expense = null;
        switch (expenseDistributionType) {
            case EQUAL:
                for(int i = 0; i<noOfUsers; i++) {
                    expenseUnits.add(
                            new ExpenseUnit(userHashMap.get(userIds.get(i)), amountPaid/(double) noOfUsers, null));
                }
                expense = ExpenseFactory.createExpense(paidUser, expenseUnits, amountPaid, ExpenseDistributionType.EQUAL);
                break;
            case EXACT:
                for(int i = 0; i<noOfUsers; i++) {
                    expenseUnits.add(
                            new ExpenseUnit(userHashMap.get(userIds.get(i)), Double.parseDouble(operands[operand++]), null));
                }
                expense = ExpenseFactory.createExpense(paidUser, expenseUnits, amountPaid, ExpenseDistributionType.EXACT);
                break;
            case PERCENT:
                for(int i = 0; i<noOfUsers; i++) {
                    expenseUnits.add(
                            new ExpenseUnit(userHashMap.get(userIds.get(i)), null, Double.parseDouble(operands[operand++])));
                }
                expense = ExpenseFactory.createExpense(paidUser, expenseUnits, amountPaid, ExpenseDistributionType.PERCENT);
                break;
        }
        expense.distributeAmount();
    }

    public void display() {
        boolean somethingToShow = false;
        for(String userId : this.userHashMap.keySet()) {
            somethingToShow |= displayForUser(userId);
        }
        if(!somethingToShow) {
            System.out.println("No balances");
        }
    }

    public boolean displayForUser(String userId) {
        boolean somethingToShow = false;
        if(this.userHashMap != null && this.userHashMap.get(userId) != null) {
            for (String user : this.userHashMap.get(userId).getOweMap().keySet()) {
                Double amount = this.userHashMap.get(userId).getOweMap().get(user);
                if (!user.equals(userId) && amount != 0.0d) {
                    somethingToShow = true;
                    System.out.println(userId + " owes " + user + ": " + amount);
                }
            }
        }
        if(!somethingToShow) {
            System.out.println("No balances");
        }
        return somethingToShow;
    }
}
