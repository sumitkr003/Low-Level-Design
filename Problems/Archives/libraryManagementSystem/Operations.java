package libraryManagementSystem;

public enum Operations {
    CREATE_LIBRARY("create_library"),
    ADD_BOOK("add_book"),
    REMOVE_BOOK_COPY("remove_book_copy"),
    BORROW_BOOK("borrow_book"),
    BORROW_BOOK_COPY("remove_book_copy"),
    RETURN_BOOK_COPY("return_book_copy"),
    PRINT_BORROWED("print_borrowed"),
    SEARCH("search"),
    EXIT("exit");

    private String action;

    Operations(String action) {
        this.action = action;
    }
    public static Operations getOperationByAction(String action) {
        for(Operations operations : Operations.values()) {
            if(operations.action.equals(action)) {
                return operations;
            }
        }
        return null;
    }
}
