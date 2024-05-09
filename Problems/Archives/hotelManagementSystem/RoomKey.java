package hotelManagementSystem;

public class RoomKey {
    private String secret;

    public RoomKey(String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return secret;
    }
}
