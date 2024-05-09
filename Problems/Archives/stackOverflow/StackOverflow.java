package stackOverflow;

import java.util.HashMap;
import java.util.Map;
import stackOverflow.content.Answer;
import stackOverflow.content.Content;
import stackOverflow.content.Question;
import stackOverflow.user.User;

public class StackOverflow implements GuestUserInterface, VerifiedUserInterface, ModeratorUserInterface{
    private Map<String, Content> questions;

    public StackOverflow() {
        this.questions = new HashMap<>();
    }

    public void updateBounty(String questionId, Integer bounty){
        ((Question)(questions.get(questionId))).updateBounty(bounty);
    }

    public void upVoteQuestion(User user, String questionId) {
        ((Question)(questions.get(questionId))).upVote(user.getUserId());
    }
    public void upVoteAnswer(User user, String answerId, String questionId) {
        ((Answer)(questions.get(answerId))).upVote(user.getUserId());
    }

    public void downVoteQuestion(User user, String questionId) {
        ((Question)(questions.get(questionId))).downVote(user.getUserId());
    }
    public void downVoteAnswer(User user, String answerId, String questionId) {
        ((Answer)(questions.get(answerId))).downVote(user.getUserId());
    }

    public void flagQuestion(User user, String questionId) {
        ((Question)(questions.get(questionId))).flag(user.getUserId());
    }
    public void flagAnswer(User user, String answerId, String questionId) {
        ((Answer)(questions.get(answerId))).flag(user.getUserId());
    }

    public void addComment(User user, String data, String questionId) {
        ((Question)(questions.get(questionId))).addComment(user, data);
    }

    public void addAnswer(User user, String data, String questionId) {
        ((Question)(questions.get(questionId))).addAnswer(user, data);
    }

    public void deleteContent(User user, String contentId) {
        questions.get(contentId).setDeleted(true);
    }
    public void recoverContent(User user, String contentId) {
        questions.get(contentId).setDeleted(false);
    }

    public void addTag(User user, String questionId, String tag) {
        ((Question)(questions.get(questionId))).addTag(tag);
    }

    public void removeTag(User user, String questionId, String tag) {
        ((Question)(questions.get(questionId))).removeTag(tag);
    }

    public Question search(String questionId) {
        return (Question)(questions.get(questionId));
    }
}
