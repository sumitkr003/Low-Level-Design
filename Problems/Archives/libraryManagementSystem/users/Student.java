package libraryManagementSystem.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import libraryManagementSystem.BookCopy;
import libraryManagementSystem.LibrarySystem;
import libraryManagementSystem.StudentLibrarySystem;

public class Student extends User{

    StudentLibrarySystem librarySystem;

    public Student(String userId, Role role, String name) {
        super(userId, role, name);
        this.role = Role.ADMIN;
        this.borrowedBooks = new HashMap<>();
    }
    public void assignLibrarySystem(StudentLibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

    public List<BookCopy> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks.values());
    }

    public void assignLibrarySystem(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

    public void borrowBookCopy(String bookCopyId, String libraryId, String dueDate) throws Exception {
        if(this.borrowedBooks.size() >= 5) {
            throw new Exception("Cannot borrow more than 5 books");
        }
        BookCopy bookCopy = this.librarySystem.borrowBookCopy(bookCopyId, this, libraryId, dueDate);
        borrowedBooks.put(bookCopyId, bookCopy);
    }

    public void borrowBook(String bookId, String libraryId, String dueDate) throws Exception {
        if(this.borrowedBooks.size() >= 5) {
            throw new Exception("Cannot borrow more than 5 books");
        }
        BookCopy bookCopy = this.librarySystem.borrowBook(bookId, this, libraryId, dueDate);
        borrowedBooks.put(bookCopy.getBookCopyId(), bookCopy);
    }

    public void returnBook(String bookCopyId, String libraryId) throws Exception {
        BookCopy bookCopy = borrowedBooks.get(bookCopyId);
        this.librarySystem.returnBook(bookCopy, this, libraryId);
        borrowedBooks.remove(bookCopyId);
    }

    public void printBorrowedBooks() {
        borrowedBooks.forEach(
                (bookCopyId, bookCopy) -> System.out.println("Book Copy: " + bookCopyId + " " + bookCopy.getDueDate()));
    }

    public void searchBy(String attribute, String attributeValue, String libraryId) throws Exception {
        this.librarySystem.searchBy(attribute, attributeValue, libraryId);
    }
}
