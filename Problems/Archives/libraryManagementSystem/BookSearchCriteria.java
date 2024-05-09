package libraryManagementSystem;

import java.util.List;

public interface BookSearchCriteria {
    List<BookCopy> meetCriteria(List<BookCopy> bookCopies, String value);
}
