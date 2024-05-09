package stackOverflow.observer;

import stackOverflow.content.Content;
import stackOverflow.notifications.EmailNotification;
import stackOverflow.notifications.SmsNotification;
import stackOverflow.user.User;
import stackOverflow.user.VerifiedUser;

public class UpvoteObserver extends Observer{
    private User user;
    public UpvoteObserver(Content content, User user) {
        super(content);
        this.user = user;
    }

    @Override
    public void update() {
        if(user instanceof VerifiedUser) {
            if(((VerifiedUser) user).getEmail() != null) {
                new EmailNotification("UpVoted", ((VerifiedUser) user).getEmail()).sendNotification();
            } else if(((VerifiedUser) user).getMobile() != null) {
                new SmsNotification("UpVoted", ((VerifiedUser) user).getMobile()).sendNotification();
            }
        }
    }
}
