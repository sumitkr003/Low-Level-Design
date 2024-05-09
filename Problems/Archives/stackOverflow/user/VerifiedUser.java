package stackOverflow.user;

import java.util.HashSet;
import java.util.Set;
import stackOverflow.StackOverflow;
import stackOverflow.VerifiedUserInterface;

public class VerifiedUser extends User{
    private String userName;
    private String password;
    private Integer reputation;
    private Set<String> badges;
    private String email;
    private String mobile;

    private VerifiedUserInterface verifiedUserInterface;
    public VerifiedUser(String userId, Role role, StackOverflow stackOverflow) {
        super(userId, role);
        this.verifiedUserInterface = stackOverflow;
        this.reputation = 0;
        this.badges = new HashSet<>();
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public void addReputation(Integer bounty) {
        this.reputation += bounty;
    }
}
