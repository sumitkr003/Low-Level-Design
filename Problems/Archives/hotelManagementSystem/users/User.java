package hotelManagementSystem.users;

public class User {
    protected String userId;
    protected Role role;

    public User(String userId, Role role) {
        this.userId = userId;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public Role getRole() {
        return role;
    }
}
