package libraryManagementSystem;

import libraryManagementSystem.users.User;

public interface StudentLibrarySystem {

    BookCopy borrowBookCopy(String bookCopyId, User user, String libraryId, String dueDate) throws Exception;
    BookCopy borrowBook(String bookId, User user, String libraryId, String dueDate) throws Exception;
    void returnBook(BookCopy bookCopy, User user, String libraryId) throws Exception;
    void searchBy(String attribute, String attributeValue, String libraryId) throws Exception;
}
