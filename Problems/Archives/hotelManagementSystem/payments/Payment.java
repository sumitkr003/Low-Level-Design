package hotelManagementSystem.payments;

public abstract class Payment {
    private boolean paid;
    private PaymentType paymentType;

    public Payment(boolean paid, PaymentType paymentType) {
        this.paid = paid;
        this.paymentType = paymentType;
    }

    public boolean isPaid() {
        return paid;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public abstract Double getCharges();
    public abstract String getServiceHeader();
}
