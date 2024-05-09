package hotelManagementSystem;

public interface GuestUserInterface {
     void bookRoom(String hotelId, Booking booking);
     void leaveRoom(String hotelId, String bookingId);
     void bookService(String hotelId, String bookingId, String serviceType);
     void accessRoom(String hotelId, RoomKey roomKey);
     void checkIn(String hotelId, Booking booking);
     void checkout(String hotelId, Booking booking);
}
