package stackOverflow.observer;

import stackOverflow.content.Content;
import stackOverflow.notifications.EmailNotification;
import stackOverflow.notifications.SmsNotification;
import stackOverflow.user.User;
import stackOverflow.user.VerifiedUser;

public class DownVoteObserver extends Observer{

    private User user;
    public DownVoteObserver(Content content, User user) {
        super(content);
        this.user = user;
    }

    @Override
    public void update() {
        if(user instanceof VerifiedUser) {
            if(((VerifiedUser) user).getEmail() != null) {
                new EmailNotification("DownVoted", ((VerifiedUser) user).getEmail()).sendNotification();
            } else if(((VerifiedUser) user).getMobile() != null) {
                new SmsNotification("DownVoted", ((VerifiedUser) user).getMobile()).sendNotification();
            }
        }
    }
}
