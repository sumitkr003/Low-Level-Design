package hotelManagementSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private String roomId;
    private List<String> roomSecrets;
    private Booking booking;

    public Room(String roomId, String masterSecret) {
        this.roomId = roomId;
        this.roomSecrets = new ArrayList<>();
        this.roomSecrets.add(masterSecret);
    }

    public boolean validateKey(RoomKey roomKey) {
        return roomSecrets.contains(roomKey.getSecret());
    }

    public void addRoomKey(RoomKey roomKey) {
        this.roomSecrets.add(roomKey.getSecret());
    }

    public void removeRoomKey(RoomKey roomKey) {
        this.roomSecrets.remove(roomKey.getSecret());
    }

    public void bookRoom(Booking booking) {
        this.booking = booking;
    }

    public void checkIn(Booking booking) {}
    public void checkout(Booking booking) {}
    public void leaveRoom() {
        this.booking = null;
    }
    public boolean isAvailable() {
        return this.booking == null;
    }
    public abstract List<String> getAmenities();
    public abstract Double getRoomCharges();
    public abstract Integer getRoomCapacity();
}
