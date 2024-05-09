package hotelManagementSystem;

import hotelManagementSystem.users.ReceptionistUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private Map<String, Room> roomMap;
    private ReceptionistUser receptionistUser;
    private List<Booking> bookingList;

    public Hotel() {
        this.roomMap = new HashMap<>();
    }

    public void addRoom(Room room) {}
    public void removeRoom(String roomId) {}
    public void appointReceptionist(ReceptionistUser receptionistUser){
        this.receptionistUser = receptionistUser;
    }

    public void addRoomKey(RoomKey roomKey) {}

    public void removeRoomKey(RoomKey roomKey) {}

    public void bookRoom(Booking booking) {}
    public void leaveRoom(String bookingId) {}

    public void bookService(String bookingId, String serviceType) {}

    public void accessRoom(RoomKey roomKey) {}

    public void checkIn(Booking booking) {}
    public void checkout(Booking booking) {}
}
