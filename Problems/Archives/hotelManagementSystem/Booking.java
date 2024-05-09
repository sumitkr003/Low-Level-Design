package hotelManagementSystem;

import hotelManagementSystem.payments.Payment;
import java.util.List;

public class Booking {
    private String bookingId;
    private Room room;
    private List<Payment> payments;
    private String checkInDate;
    private Integer nights;
    private String checkOutDate;

    public Booking(String bookingId, Room room, String checkInDate, Integer nights, String checkOutDate) {
        this.bookingId = bookingId;
        this.room = room;
        this.checkInDate = checkInDate;
        this.nights = nights;
        this.checkOutDate = checkOutDate;
    }

    public void addPayment(Payment payment) {
        this.payments.add(payment);
    }

    public void cancelBooking() {}

    public void checkout() {

    }
}
