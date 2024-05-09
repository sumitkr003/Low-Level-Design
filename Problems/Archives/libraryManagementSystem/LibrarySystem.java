package libraryManagementSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import libraryManagementSystem.users.Admin;
import libraryManagementSystem.users.Role;
import libraryManagementSystem.users.Student;
import libraryManagementSystem.users.User;

public class LibrarySystem implements StudentLibrarySystem, AdminLibrarySystem {
    Map<String, Library> libraryMap;
    Map<String, User> usersMap;

    public LibrarySystem() {
        this.libraryMap = new HashMap<>();
        this.usersMap = new HashMap<>();
    }

    public void createLibrary(Integer noOfRacks, String libraryId) {
        Library library = new Library(noOfRacks, libraryId);
        libraryMap.put(library.getLibraryId(), library);
        System.out.println("Created library with " + noOfRacks +" racks");
        return;
    }

    public boolean doesUserExist(String userId) {
        return usersMap.containsKey(userId);
    }

    public User getUser(String userId) {
        return usersMap.get(userId);
    }

    public User createUser(String name, Role role, String userId) {
        User user = null;
        if(Role.STUDENT == role) {
            user = new Student(userId, role, name);
            ((Student) user).assignLibrarySystem(this);
        } else if(Role.ADMIN == role) {
            user = new Admin(userId, role, name);
            ((Admin) user).assignLibrarySystem(this);
        }
        usersMap.put(userId, user);
        return user;
    }

    public void addBooks(String libraryId, String bookId, String title, List<String> authors, List<String> publishers, List<String> bookCopyIds)
            throws Exception {
        List<Rack> racks = getLibrary(libraryId).addBooks(bookId, title, authors, publishers, bookCopyIds);
        List<Integer> rackIds = racks.stream().map(Rack::getRackId).collect(Collectors.toList());
        String ids = "";
        for(int i = 0 ; i< rackIds.size(); i++) {
            ids = ids + rackIds.get(0) + ",";
        }
        System.out.println("Added books to racks : " + ids);
    }

    public void removeBookCopy(String libraryId, String bookCopyId) throws Exception {
        getLibrary(libraryId).removeBookCopy(bookCopyId);
    }

    public BookCopy borrowBookCopy(String bookCopyId, User user, String libraryId, String dueDate) throws Exception {
        Library library = getLibrary(libraryId);
        BookCopy bookCopy = library.borrowBook(dueDate);
        bookCopy.dueDate = dueDate;
        return bookCopy;
    }

    public BookCopy borrowBook(String bookId, User user, String libraryId, String dueDate) throws Exception {
        Library library = getLibrary(libraryId);
        BookCopy bookCopy = library.borrowBookId(bookId);
        bookCopy.dueDate = dueDate;
        return bookCopy;
    }

    public void returnBook(BookCopy bookCopy, User user, String libraryId) throws Exception {
        Library library = getLibrary(libraryId);
        library.returnBook(bookCopy);
    }

    private Library getLibrary(String libraryId) throws Exception {
        if(libraryMap.containsKey(libraryId)) {
            return libraryMap.get(libraryId);
        }
        throw new Exception("Library with libraryId : " + libraryId + " not found.");
    }

    public void searchBy(String attribute, String attributeValue, String libraryId) throws Exception {
        SearchAttribute searchAttribute = SearchAttribute.getSearchAttribute(attribute);
        Library library = getLibrary(libraryId);
        switch (searchAttribute) {
            case BOOK_ID:
                library.searchByBookId(attributeValue);
                break;
            case AUTHOR_ID:
                library.searchByAuthorId(attributeValue);
                break;
        }
        return;
    }
}
