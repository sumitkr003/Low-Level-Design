package stackOverflow.user;

public abstract class User {
    private String userId;
    private Role role;

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
