package hotelManagementSystem;

import hotelManagementSystem.users.ReceptionistUser;
import java.util.Map;

public class HotelManagementSystem implements GuestUserInterface, ReceptionistUserInterface{
    private Map<String, Hotel> hotelMap;

    private Hotel getHotelByHotelId(String hotelId) {
        return hotelMap.get(hotelId);
    }

    public void addRoom(String hotelId, Room room) {}
    public void removeRoom(String hotelId, String roomId) {}
    public void appointReceptionist(String hotelId, ReceptionistUser receptionistUser){}

    public void addRoomKey(String hotelId, RoomKey roomKey) {}

    public void removeRoomKey(String hotelId, RoomKey roomKey) {}

    public void bookRoom(String hotelId, Booking booking) {}

    public void checkIn(String hotelId, Booking booking) {}

    public void leaveRoom(String hotelId, String bookingId) {}

    public void bookService(String hotelId, String bookingId, String serviceType) {}

    public void accessRoom(String hotelId, RoomKey roomKey) {}
    public void checkout(String hotelId, Booking booking) {}
}
