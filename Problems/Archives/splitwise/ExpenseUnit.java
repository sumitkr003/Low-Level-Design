package splitwise;

public class ExpenseUnit {
    public User user;
    public Double amount;
    public Double percentage;

    public ExpenseUnit(User user, Double amount, Double percentage) {
        this.user = user;
        this.amount = amount;
        this.percentage = percentage;
    }
}
