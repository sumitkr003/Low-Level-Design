package hotelManagementSystem.payments;

import hotelManagementSystem.Room;

public class RoomPayment extends Payment{
    private Room room;
    private Integer nights;
    private static final String HEADER = "ROOM CHARGES";

    public RoomPayment(boolean paid, PaymentType paymentType, Room room, Integer nights) {
        super(paid, paymentType);
        this.room = room;
        this.nights = nights;
    }

    @Override
    public Double getCharges() {
        return this.room.getRoomCharges() * this.nights;
    }

    @Override
    public String getServiceHeader() {
        return HEADER;
    }
}
