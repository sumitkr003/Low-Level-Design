Code for Library Management System
- we assume there is necessary getter and setters functions and for simplicity we won't be defining them

### Enums and Constants
```
public enum BookFormat {
  HARDCOVER,
  PAPERBACK,
  EBOOK,
  MAGAZINE,
  JOURNAL
}

public enum BookStatus {
  AVAILABLE,
  RESERVED,
  ISSUED,
  LOST
}

public enum ReservationStatus {
  PENDING,
  CANCELED,
  BLACKLISTED,
  RESERVED
}

public enum AccountStatus {
  ACTIVE,
  INACTIVE,
  CLOSED,
  BLACKLISTED
}

public class Address {
  private String streetAddress;
  private String city;
  private String state;
  private int zipcode;
  private String country;
}

public class Phone {
  private int countryCode;
  private long number;
}

public class User {
  private String name;
  private Address address;
  private String email;
  private Phone phone;
}

private enum MAX_DAYS_BOOK_LOANED {
  10
}

private enum MAX_BOOKS_ISSUED {
  5
}

private enum FINE_AMOUNT {
  10
}
```

### Actor classes (Member, Librarian)
```
public abstract class Account {
  private String id;
  private User user;
  private String password;
  private AccountStatus status;

  private boolean resetPassword();
  private boolean updateAccountStatus();
}

public class Librarian extends Account {

  public boolean addBookItem(BookItem item);
  public boolean removeBookItem(BookItem item);
  public boolean editBook(BookItem item);

  public boolean registerMember(Member user);
  public boolean updateMember(Member user);
  public boolean issueLibraryCard(Member user);
}

public class Member extends Account {
  private Date membershipDate;
  private List<BookItem> issuedBook;
}
```

### BookItem class
```
public abstract class Book {
  private String id;
  private String title;
  private String isbn;
  private String category;
  private String publisher;
  private List<Author> authors;
  private int numPages;
  private String language;
}

public class Rack {
  private int number;
  private String locationIdentifier;
}

private class BookItem extends Book {
  private String barcode;
  private Date issueDate;
  private Date dueDate;
  private double price;
  private BookFormat format;
  private BookStatus status;
  private Date dateOfPurchase;
  private Date publicationDate;
  private Rack rack;
  private boolean isReferenceOnly;

  public boolean checkout(String memeberId){
    if(this.getIsReferenceOnly()) {
      log("This book is for reference only and cannot be issued");
      return false;
    }

    if(!BookService.lendBook(this.getBarCode(), memberId)){
      return false;
    }
    this.updateBookItemStatus(BookStatus.LOANED);
    return true;
  }
}
```

### Service Class
```
public class BookService {

  private boolean reserveBook(BookItem book, Member member);
  private boolean issueBook(BookItem book, Member member);
  private boolean returnBook(BookItem book, Member member);
  private boolean renewBook(BookItem book, Member member);
}

public class PaymentService {
  private boolean processPayment(double amount);
  private double getFine(Date dueDate);
}

public interface Search {
  public List<Book> searchByTitle(String title);
  public List<Book> searchByCategory(String category);
  public List<Book> searchByAuthor(String author);
  public List<Book> searchByPublicationYear(int year);
}

public class Catalog implements Search {
  private HashMap<String, List<Book>> bookTitles;
  private HashMap<String, List<Book>> bookAuthors;
  private HashMap<String, List<Book>> bookCategories;
  private HashMap<String, List<Book>> bookPublicationYear;  
}
```