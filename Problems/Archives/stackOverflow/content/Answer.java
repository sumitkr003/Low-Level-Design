package stackOverflow.content;

import java.util.List;
import stackOverflow.observer.DownVoteObserver;
import stackOverflow.observer.UpvoteObserver;
import stackOverflow.user.User;

public class Answer extends Content{
    private Question question;
    private List<Comment> comments;

    public Answer(User user, String data, Question question) {
        super(user, data);
        this.question = question;
        new UpvoteObserver(this, user);
        new DownVoteObserver(this, user);
    }

    public Question getQuestion() {
        return question;
    }

    public void upVote(String userId) {
        this.upVotedUsers.add(userId);
        this.notifyValidObservers(this.contentId, false);
    }
    public void downVote(String userId) {
        this.downVotedUsers.add(userId);
        this.notifyValidObservers(this.contentId, true);
    }
    public void flag(String userId) {
        this.flaggedUsers.add(userId);
    }

    public void addComment(User user, String data) {
        this.comments.add(new Comment(user, data));
    }
}
