package hotelManagementSystem.users;

import hotelManagementSystem.HotelManagementSystem;

public class UserFactory {
    public static User createUser(String userId, String role, HotelManagementSystem hotelManagementSystem) {
        Role r = Role.getRole(role);
        switch (r) {
            case RECEPTIONIST:
                return new ReceptionistUser(userId, r, hotelManagementSystem);
            case GUEST:
                return new GuestUser(userId, r, hotelManagementSystem);
        }
        return null;
    }
}
