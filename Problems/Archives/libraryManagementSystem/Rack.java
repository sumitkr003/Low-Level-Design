package libraryManagementSystem;

public class Rack {
    private Integer rackId;
    private BookCopy bookCopy;

    public Rack(Integer id) {
        this.rackId = id;
    }

    public void storeBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public void releaseBook() {
        this.bookCopy = null;
    }
    public Integer getRackId() {
        return rackId;
    }
    public boolean isEmpty() {
        return bookCopy == null;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }
}
