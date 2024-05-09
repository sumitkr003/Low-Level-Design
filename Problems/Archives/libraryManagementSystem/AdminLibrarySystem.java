package libraryManagementSystem;

import java.util.List;
import libraryManagementSystem.users.Role;
import libraryManagementSystem.users.User;

public interface AdminLibrarySystem {
    void searchBy(String attribute, String attributeValue, String libraryId) throws Exception;
    void returnBook(BookCopy bookCopy, User user, String libraryId) throws Exception;
    BookCopy borrowBook(String bookId, User user, String libraryId, String dueDate) throws Exception;
    BookCopy borrowBookCopy(String bookCopyId, User user, String libraryId, String dueDate) throws Exception;
    void addBooks(String libraryId, String bookId, String title, List<String> authors, List<String> publishers, List<String> bookCopyIds)
            throws Exception;
    void createLibrary(Integer noOfRacks, String libraryId);
    boolean doesUserExist(String userId);
    User createUser(String name, Role role, String userId);
    void removeBookCopy(String libraryId, String bookCopyId) throws Exception;
    User getUser(String userId);
}
