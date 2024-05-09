package splitwise;

import java.util.HashMap;

public class User {
    private String userId;
    private HashMap<String, Double> oweMap;

    public User(String userId) {
        this.userId = userId;
        this.oweMap = new HashMap<>();
    }

    public String getUserId() {
        return this.userId;
    }

    public HashMap<String, Double> getOweMap() {
        return this.oweMap;
    }
}
