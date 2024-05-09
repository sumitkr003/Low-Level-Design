package libraryManagementSystem.users;

import libraryManagementSystem.AdminLibrarySystem;

public class Admin extends User {
    AdminLibrarySystem adminLibrarySystem;

    public Admin(String userId, Role role, String name) {
        super(userId, role, name);
        this.role = Role.ADMIN;
    }
    public void assignLibrarySystem(AdminLibrarySystem librarySystem) {
        this.adminLibrarySystem = librarySystem;
    }

    public AdminLibrarySystem getAdminLibrarySystem() {
        return adminLibrarySystem;
    }
}
