package libraryManagementSystem.users;

import libraryManagementSystem.LibrarySystem;

public class Manager extends User {
    LibrarySystem librarySystem;

    public Manager(String userId, Role role, String name) {
        super(userId, role, name);
        this.role = Role.MANAGER;
    }
}
