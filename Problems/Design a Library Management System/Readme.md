## System Requirements

1. Any library member should be able to search books by their title, author, subject category as well by the publication date.

2. Each book will have a unique identification number and other details including a rack number which will help to physically locate the book.

3. There could be more than one copy of a book, and library members should be able to check-out and reserve any copy. We will call each copy of a book, a book item.

4. The system should be able to retrieve information like who took a particular book or what are the books checked-out by a specific library member.

5. There should be a maximum limit (5) on how many books a member can check-out.

6. There should be a maximum limit (10) on how many days a member can keep a book.

7. The system should be able to collect fines for books returned after the due date.

8. Members should be able to reserve books that are not currently available.

9. The system should be able to send notifications whenever the reserved books become available, as well as when the book is not returned within the due date.

10. Each book and member card will have a unique barcode. The system will be able to read barcodes from books and members’ library cards.


## Use case diagram

### Actors
1. **Librarian**: Mainly responsible for adding and modifying books, book items, and users. The Librarian can also issue, reserve, and return book items

2. **Member**: All members can search the catalog, as well as check-out, reserve, renew, and return a book

3. **System**: Mainly responsible for sending notifications for overdue books, canceled reservations, etc.

### Use cases/functionalities
1. **Add/Remove/Edit book**: To add, remove or modify a book or book item.

2. **Search catalog**: To search books by title, author, subject or publication date.

3. **Register new account/cancel membership**: To add a new member or cancel the membership of an existing member.

4. **Check-out book**: To borrow a book from the library.

5. **Reserve book**: To reserve a book which is not currently available.

6. **Renew a book**: To reborrow an already checked-out book.

7. **Return a book**: To return a book to the library which was issued to a member.

### Diagram
![use case diagram](images/useCaseDiagram.png)

## Class Diagram
Below are the main classes:

1. **Library**: The central part of the organization for which this software has been designed. It has attributes like ‘Name’ to distinguish it from any other libraries and ‘Address’ to describe its location.

2. **Book**: The basic building block of the system. Every book will have ISBN, Title, Subject, Publishers, etc.

3. **BookItem**: Any book can have multiple copies, each copy will be considered a book item in our system. Each book item will have a unique barcode.

4. **Account**: We will have two types of accounts in the system, one will be a general member, and the other will be a librarian.

5. **LibraryCard**: Each library user will be issued a library card, which will be used to identify users while issuing or returning books.

6. **BookReservation**: Responsible for managing reservations against book items.

7. **BookLending**: Manage the checking-out of book items.

8. **Catalog**: Catalogs contain list of books sorted on certain criteria. Our system will support searching through four catalogs: Title, Author, Subject, and Publish-date.

9. **Fine**: This class will be responsible for calculating and collecting fines from library members.

10. **Author**: This class will encapsulate a book author.

11. **Rack**: Books will be placed on racks. Each rack will be identified by a rack number and will have a location identifier to describe the physical location of the rack in the library.

12. **Notification**: This class will take care of sending notifications to library members.

### Diagram
![class diagram](images/classDiagram.png)

### UML Conventions
![uml conventions](images/umlConvention.svg)
