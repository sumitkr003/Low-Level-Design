package libraryManagementSystem;

import java.util.List;

public class BookCopy extends Book {
    String bookCopyId;
    Rack rack;
    boolean borrowed;
    String dueDate;

    public BookCopy(String bookCopyId, String bookId, String title, List<String> authors, List<String> publishers) {
        super(bookId, title, authors, publishers);
        this.borrowed = false;
        this.bookCopyId = bookCopyId;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void assignRack(Rack rack) {
        this.rack = rack;
    }
}
