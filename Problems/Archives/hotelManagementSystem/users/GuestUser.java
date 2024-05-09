package hotelManagementSystem.users;

import hotelManagementSystem.GuestUserInterface;
import hotelManagementSystem.RoomKey;

public class GuestUser extends User {
    private RoomKey roomKey;
    private GuestUserInterface guestUserInterface;

    public GuestUser(String userId, Role role, GuestUserInterface guestUserInterface) {
        super(userId, role);
        this.guestUserInterface = guestUserInterface;
    }

    public void assignKey(RoomKey roomKey) {
        this.roomKey = roomKey;
    }
}
