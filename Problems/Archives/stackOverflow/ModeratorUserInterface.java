package stackOverflow;

import stackOverflow.user.User;

public interface ModeratorUserInterface {
    void deleteContent(User user, String contentId);
    void recoverContent(User user, String contentId);
}
