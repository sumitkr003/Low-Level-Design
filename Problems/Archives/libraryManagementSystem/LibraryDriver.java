package libraryManagementSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import libraryManagementSystem.users.Admin;
import libraryManagementSystem.users.Role;
import libraryManagementSystem.users.Student;

public class LibraryDriver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LibrarySystem librarySystem = new LibrarySystem();
        Admin admin = (Admin) librarySystem.createUser("Raman", Role.ADMIN, "Admin123");
        while(true) {
            String commandLine = in.nextLine();
            String[] operands = commandLine.split(" ");
            Operations operation = Operations.getOperationByAction(operands[0]);
            try {
                Student student = null;
                switch (operation) {
                    case CREATE_LIBRARY:
                        admin.getAdminLibrarySystem().createLibrary(Integer.parseInt(operands[1]), operands[2]);
                        break;
                    case ADD_BOOK:
                        String bookId = operands[1];
                        String title = operands[2];
                        List<String> authors = Arrays.stream(operands[3].split(",")).collect(Collectors.toList());
                        List<String> publishers = Arrays.stream(operands[4].split(",")).collect(Collectors.toList());
                        List<String> bookCopyIds = Arrays.stream(operands[5].split(",")).collect(Collectors.toList());
                        admin.getAdminLibrarySystem().addBooks("1234", bookId, title, authors, publishers, bookCopyIds);
                        break;
                    case REMOVE_BOOK_COPY:
                        admin.getAdminLibrarySystem().removeBookCopy("1234", operands[1]);
                        break;
                    case BORROW_BOOK:
                        if(!admin.getAdminLibrarySystem().doesUserExist(operands[2])) {
                            admin.getAdminLibrarySystem().createUser(operands[2], Role.STUDENT, operands[2]);
                        }
                        student = (Student) admin.getAdminLibrarySystem().getUser(operands[2]);
                        student.borrowBook(operands[1], "1234", operands[3]);
                        break;
                    case BORROW_BOOK_COPY:
                        if(!admin.getAdminLibrarySystem().doesUserExist(operands[2])) {
                            admin.getAdminLibrarySystem().createUser(operands[2], Role.STUDENT, operands[2]);
                        }
                        student = (Student) admin.getAdminLibrarySystem().getUser(operands[2]);
                        student.borrowBookCopy(operands[1], "1234", operands[3]);
                        break;
                    case RETURN_BOOK_COPY:
                        if(!admin.getAdminLibrarySystem().doesUserExist(operands[2])) {
                            admin.getAdminLibrarySystem().createUser(operands[2], Role.STUDENT, operands[2]);
                        }
                        student = (Student) admin.getAdminLibrarySystem().getUser(operands[2]);
                        student.returnBook(operands[1], "1234");
                        break;
                    case PRINT_BORROWED:
                        if(!admin.getAdminLibrarySystem().doesUserExist(operands[1])) {
                            admin.getAdminLibrarySystem().createUser(operands[1], Role.STUDENT, operands[1]);
                        }
                        student = (Student) admin.getAdminLibrarySystem().getUser(operands[1]);
                        student.printBorrowedBooks();
                        break;
                    case SEARCH:
                        admin.getAdminLibrarySystem().searchBy(operands[1], operands[2], "1234");
                        break;
                    case EXIT:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


//create_library 10 1234
//add_book 1 book1 author1,author2 publisher1 book_copy1,book_copy2,book_copy3
//add_book 2 book2 author2,author3 publisher2,publisher3 book_copy4,book_copy5,book_copy6,book_copy7,book_copy8,book_copy9,book_copy10
//add_book 3 book3 author2 publisher2 book_copy11,book_copy12,book_copy13
//search book_id 1
//search book_id 3
//search author_id author2
//search author_id author3
//remove_book_copy book_copy6
//remove_book_copy book_copy13
//add_book 3 book3 author2 publisher2 book_copy13
//search book_id 2
//print_borrowed user1
//borrow_book 1 user1 2020-12-31
//borrow_book 1 user1 2020-12-31
//borrow_book 1 user1 2020-12-31
//borrow_book 1 user1 2020-12-31
//search book_id 1
//search author_id author1
//borrow_book 4 user1 2020-12-31
//borrow_book 2 user1 2020-12-31
//borrow_book 2 user1 2020-12-31
//borrow_book 2 user1 2020-12-31
//print_borrowed user1
//print_borrowed user1
//exit