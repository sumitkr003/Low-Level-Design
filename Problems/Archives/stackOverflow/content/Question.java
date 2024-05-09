package stackOverflow.content;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import stackOverflow.observer.DownVoteObserver;
import stackOverflow.observer.UpvoteObserver;
import stackOverflow.user.Role;
import stackOverflow.user.User;
import stackOverflow.user.VerifiedUser;

public class Question extends Content{
    private List<Answer> answers;
    private List<Comment> comments;
    private Integer bounty;
    private Set<String> tags;

    public Question(User user, String data, Integer bounty) {
        super(user, data);
        this.answers = new ArrayList<>();
        this.bounty = bounty;
        this.tags = new HashSet<>();
        new UpvoteObserver(this, user);
        new DownVoteObserver(this, user);
    }

    public void updateBounty(Integer bounty) {
        this.bounty = bounty;
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

    public void addAnswer(User user, String data) {
        this.answers.add(new Answer(user, data, this));
        if(Role.VERIFIED == user.getRole()) {
            ((VerifiedUser) user).addReputation(this.bounty);
        }
    }

    public Integer getBounty() {
        return bounty;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
    }
}
