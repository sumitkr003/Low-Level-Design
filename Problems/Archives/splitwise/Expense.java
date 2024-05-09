package splitwise;

import java.util.List;

public abstract class Expense {
    private Double amount;
    private User paidUser;
    private List<ExpenseUnit> expenseUnits;
    private ExpenseDistributionType expenseDistributionType;

    public Expense(User user, List<ExpenseUnit> expenseUnits, Double amount, ExpenseDistributionType expenseDistributionType) {
        this.amount = amount;
        this.paidUser = user;
        this.expenseUnits = expenseUnits;
        this.expenseDistributionType = expenseDistributionType;
    }
    public abstract void distributeAmount();

    public void simplifySettle(User user1, User user2) {
        Double user1OwesUser2 = user1.getOweMap().get(user2.getUserId());
        Double user2OwesUser1 = user2.getOweMap().get(user1.getUserId());
        if(user1OwesUser2 != null && user2OwesUser1 != null) {
            if(user1OwesUser2 < user2OwesUser1) {
                Double diff = user2OwesUser1 - user1OwesUser2;
                user2.getOweMap().put(user1.getUserId(), diff);
                user1.getOweMap().put(user2.getUserId(), 0.0d);
            } else {
                Double diff = user1OwesUser2 - user2OwesUser1;
                user2.getOweMap().put(user1.getUserId(), 0.0d);
                user1.getOweMap().put(user2.getUserId(), diff);
            }
        }
    }

    protected List<ExpenseUnit> getExpenseUnits() {
        return this.expenseUnits;
    }
    public User getPaidUser() {
        return this.paidUser;
    }
    public Double getAmount() {
        return this.amount;
    }
}
