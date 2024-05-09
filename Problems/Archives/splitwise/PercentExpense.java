package splitwise;

import java.util.HashMap;
import java.util.List;

public class PercentExpense extends Expense{

    public PercentExpense(User user, List<ExpenseUnit> expenseUnits, Double amount) {
        super(user, expenseUnits, amount, ExpenseDistributionType.PERCENT);
    }
    @Override
    public void distributeAmount() {
        List<ExpenseUnit> expenseUnits = getExpenseUnits();
        for(ExpenseUnit expenseUnit : expenseUnits) {
            if(expenseUnit.user != this.getPaidUser()) {
                HashMap<String, Double> oweMap = expenseUnit.user.getOweMap();
                oweMap.putIfAbsent(expenseUnit.user.getUserId(), 0.00d);
                // calculate expense amount from percentage
                expenseUnit.amount = (this.getAmount() * expenseUnit.percentage) / (double) 100.00d;
                oweMap.put(this.getPaidUser().getUserId(), oweMap.getOrDefault(this.getPaidUser().getUserId(), 0.0d) + expenseUnit.amount);
                super.simplifySettle(super.getPaidUser(), expenseUnit.user);
            }
        }
    }
}
