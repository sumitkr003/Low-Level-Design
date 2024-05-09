package libraryManagementSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class Library {
    private String libraryId;
    private List<Rack> racks;
    private Map<String, BookCopy> bookCopies;

    public Library(Integer noOfRacks, String libraryId) {
        this.libraryId = libraryId;
        this.racks = new ArrayList<>();
        for(int rack = 0; rack < noOfRacks; rack++) {
            racks.add(new Rack(rack));
        }
        this.bookCopies = new HashMap<>();
    }

    public List<Rack> addBooks(String bookId, String title, List<String> authors, List<String> publishers, List<String> bookCopyIds)
            throws Exception {
        List<Rack> racksAssigned = new ArrayList<>();
        for(String bookCopyId : bookCopyIds) {
            BookCopy bookCopy = new BookCopy(bookCopyId, bookId, title, authors, publishers);
            Rack optimalFreeRack = findRack();
            if(optimalFreeRack == null) {
                throw new Exception("All Racks are full");
            }
            bookCopy.assignRack(optimalFreeRack);
            optimalFreeRack.storeBookCopy(bookCopy);
            racksAssigned.add(optimalFreeRack);
            this.bookCopies.put(bookCopyId, bookCopy);
        }
        return racksAssigned;
    }

    public void removeBookCopy(String bookCopyId) throws Exception{
        if(!bookCopies.containsKey(bookCopyId)) {
            throw new Exception("Provided BookCopyId not found");
        }
        BookCopy bookCopy = bookCopies.get(bookCopyId);
        Rack rack = bookCopy.rack;
        rack.releaseBook();
        bookCopies.remove(bookCopyId);
        System.out.println("Removed book copy:" + bookCopyId + " from rack: " + rack.getRackId());
        return;
    }

    public BookCopy borrowBook(String bookCopyId) throws Exception {
        Rack rack = racks.stream().filter(r -> !r.isEmpty()).filter(r -> r.getBookCopy().bookCopyId.equals(bookCopyId))
                .min(Comparator.comparingInt(Rack::getRackId)).orElse(null);
        if(rack == null) {
            throw new Exception("BookCopyId not found");
        }
        BookCopy bookCopy = rack.getBookCopy();
        bookCopy.borrowed = true;
        rack.releaseBook();
        bookCopy.rack = null;
        System.out.println("Borrowed BookCopy from rack: " + rack.getRackId());
        return bookCopy;
    }

    public BookCopy borrowBookId(String bookId) throws Exception {
        Rack rack = racks.stream().filter(r -> !r.isEmpty()).filter(r -> r.getBookCopy().bookId.equals(bookId))
                .min(Comparator.comparingInt(Rack::getRackId)).orElse(null);
        if(rack == null) {
            throw new Exception("BookCopyId not found");
        }
        BookCopy bookCopy = rack.getBookCopy();
        bookCopy.borrowed = true;
        rack.releaseBook();
        bookCopy.rack = null;
        System.out.println("Borrowed Book from rack: " + rack.getRackId());
        return bookCopy;
    }

    public void returnBook(BookCopy bookCopy) throws Exception {
        Rack optimalFreeRack = findRack();
        if(optimalFreeRack == null) {
            throw new Exception("All Racks are full");
        }
        bookCopy.assignRack(optimalFreeRack);
        optimalFreeRack.storeBookCopy(bookCopy);
        bookCopy.dueDate = null;
        bookCopy.borrowed = false;
        System.out.println("Returned book copy " + bookCopy.getBookCopyId() + " and added to rack: " + optimalFreeRack.getRackId());
        return;
    }

    public void searchByBookId(String bookId) {
        List<BookCopy> filtered = new BookCopyBookIdCriteria().meetCriteria(new ArrayList<>(bookCopies.values()), bookId);
        for(BookCopy bookCopy : filtered) {
            printBookCopySearch(bookCopy);
        }
    }

    public void searchByAuthorId(String authorId) {
        List<BookCopy> filtered = new BookCopyAuthorIdSearchCriteria().meetCriteria(new ArrayList<>(bookCopies.values()), authorId);
        for(BookCopy bookCopy : filtered) {
            printBookCopySearch(bookCopy);
        }
    }

    private void printBookCopySearch(BookCopy bookCopy) {
        System.out.println(
                "Book Copy: " + bookCopy.getBookCopyId() + " " + bookCopy.getBookId() + " " + bookCopy.getTitle() + " "
                        + (bookCopy.borrowed ? "-1 " + bookCopy.getDueDate() : bookCopy.rack.getRackId()));
    }

    private Rack findRack() {
        return racks.stream().filter(Rack::isEmpty).collect(Collectors.toList()).stream()
                .min(Comparator.comparingInt(Rack::getRackId)).orElse(null);
    }

    public String getLibraryId() {
        return libraryId;
    }
}
