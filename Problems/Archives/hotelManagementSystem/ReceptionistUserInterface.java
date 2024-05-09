package hotelManagementSystem;

import hotelManagementSystem.users.ReceptionistUser;

public interface ReceptionistUserInterface {
    void addRoom(String hotelId, Room room);
    void removeRoom(String hotelId, String roomId);
    void appointReceptionist(String hotelId, ReceptionistUser receptionistUser);
    void addRoomKey(String hotelId, RoomKey roomKey);
    void removeRoomKey(String hotelId, RoomKey roomKey);
    void bookRoom(String hotelId, Booking booking);
    void checkIn(String hotelId, Booking booking);
    void leaveRoom(String hotelId, String bookingId);
    void bookService(String hotelId, String bookingId, String serviceType);
    void accessRoom(String hotelId, RoomKey roomKey);
    void checkout(String hotelId, Booking booking);
}
