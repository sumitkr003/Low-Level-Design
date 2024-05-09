package stackOverflow.content;

import stackOverflow.user.User;

public class Comment extends Content {

    public Comment(User user, String data) {
        super(user, data);
    }

    public void upVote(String userId) {
        this.upVotedUsers.add(userId);
    }
}
