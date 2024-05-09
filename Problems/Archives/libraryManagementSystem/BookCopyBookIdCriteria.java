package libraryManagementSystem;

import java.util.List;
import java.util.stream.Collectors;

public class BookCopyBookIdCriteria implements BookSearchCriteria{

    @Override
    public List<BookCopy> meetCriteria(List<BookCopy> bookCopies, String value) {
        return bookCopies.stream().filter(bookCopy -> bookCopy.getBookId().equals(value)).collect(
                Collectors.toList());
    }
}
