package hotelManagementSystem.users;

public enum Role {
    GUEST,
    HOUSEKEEPER,
    ADMIN,
    RECEPTIONIST;

    public static Role getRole(String role) {
        for(Role r : Role.values()) {
            if(r.name().equals(role)) {
                return r;
            }
        }
        return null;
    }
}
