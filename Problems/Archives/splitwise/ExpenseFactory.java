package splitwise;

import java.util.List;

public class ExpenseFactory {
    public static Expense createExpense(User user, List<ExpenseUnit> expenseUnits, Double amount, ExpenseDistributionType expenseDistributionType)  {
        if(ExpenseDistributionType.EQUAL == expenseDistributionType) {
            return new EqualExpense(user, expenseUnits, amount);
        }
        if(ExpenseDistributionType.EXACT == expenseDistributionType) {
            return new ExactExpense(user, expenseUnits, amount);
        }
        if(ExpenseDistributionType.PERCENT == expenseDistributionType) {
            return new PercentExpense(user, expenseUnits, amount);
        }
        return null;
    }
}
