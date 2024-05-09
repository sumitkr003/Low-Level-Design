package stackOverflow.content;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import stackOverflow.observer.DownVoteObserver;
import stackOverflow.observer.Observer;
import stackOverflow.observer.UpvoteObserver;
import stackOverflow.user.User;

public abstract class Content {
    protected String contentId;
    private User user;
    protected String data;
    protected Set<String> upVotedUsers;
    protected Set<String> downVotedUsers;
    protected Set<String> flaggedUsers;
    protected boolean deleted;
    protected List<Observer> observers;

    public Content(User user, String data) {
        this.contentId = UUID.randomUUID().toString();
        this.user = user;
        this.data = data;
        this.upVotedUsers = new HashSet<>();
        this.downVotedUsers = new HashSet<>();
        this.flaggedUsers = new HashSet<>();
        this.observers = new ArrayList<>();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    public User getUser() {
        return user;
    }

    public String getData() {
        return data;
    }

    public int getUpVotes() {
        return upVotedUsers.size();
    }

    public int getDownVotes() {
        return downVotedUsers.size();
    }

    public int getFlags() {
        return flaggedUsers.size();
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    protected void notifyValidObservers(String contentId, boolean downVote){
        for (Observer observer : observers.stream().filter(o -> o.getContent().contentId.equals(contentId))
                .filter(o -> downVote ? (o instanceof DownVoteObserver) : (o instanceof UpvoteObserver))
                .collect(Collectors.toList())) {
            observer.update();
        }
    }
}
