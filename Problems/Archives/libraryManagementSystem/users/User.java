package libraryManagementSystem.users;

import java.util.Map;
import libraryManagementSystem.BookCopy;

public class User {
    protected String userId;
    protected Role role;
    protected String name;
    protected Map<String, BookCopy> borrowedBooks;

    public User(String userId, Role role, String name) {
        this.userId = userId;
        this.role = role;
        this.name = name;
    }

    public Role getRole() {
        return this.role;
    }
    public String getUserId() {
        return this.userId;
    }
}
