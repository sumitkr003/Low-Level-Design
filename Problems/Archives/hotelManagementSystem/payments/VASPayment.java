package hotelManagementSystem.payments;

import hotelManagementSystem.Room;

public class VASPayment extends Payment{
    private ServiceCharge serviceCharge;

    public VASPayment(boolean paid, PaymentType paymentType, Room room, ServiceCharge serviceCharge) {
        super(paid, paymentType);
        this.serviceCharge = serviceCharge;
    }

    @Override
    public Double getCharges() {
        return this.serviceCharge.getAmount();
    }

    @Override
    public String getServiceHeader() {
        return this.serviceCharge.getServiceType().name();
    }
}
