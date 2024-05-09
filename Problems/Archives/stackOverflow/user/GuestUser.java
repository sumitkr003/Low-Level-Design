package stackOverflow.user;

import stackOverflow.GuestUserInterface;
import stackOverflow.StackOverflow;

public class GuestUser extends User {
    private GuestUserInterface guestUserInterface;
    public GuestUser(String userId, Role role, StackOverflow stackOverflow) {
        super(userId, role);
        this.guestUserInterface = stackOverflow;
    }
}
