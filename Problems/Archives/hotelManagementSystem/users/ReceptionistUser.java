package hotelManagementSystem.users;

import hotelManagementSystem.ReceptionistUserInterface;
import hotelManagementSystem.RoomKey;

public class ReceptionistUser extends User{
    private RoomKey masterKey;
    private ReceptionistUserInterface receptionistUserInterface;

    public ReceptionistUser(String userId, Role role, ReceptionistUserInterface receptionistUserInterface) {
        super(userId, role);
        this.receptionistUserInterface = receptionistUserInterface;
    }

    public void assignKey(RoomKey roomKey) {
        this.masterKey = roomKey;
    }
}
