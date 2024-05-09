package stackOverflow;

import stackOverflow.user.User;

public interface VerifiedUserInterface {

    void updateBounty(String questionId, Integer bounty);

    void upVoteQuestion(User user, String questionId);
    void upVoteAnswer(User user, String answerId, String questionId);

    void downVoteQuestion(User user, String questionId);
    void downVoteAnswer(User user, String answerId, String questionId);

    void flagQuestion(User user, String questionId);
    void flagAnswer(User user, String answerId, String questionId);

    void addComment(User user, String data, String questionId);

    void addAnswer(User user, String data, String questionId);

    void addTag(User user, String questionId, String tag);

    void removeTag(User user, String questionId, String tag);
}
