## Solid Principles

SOLID is an acronym for the first five object-oriented design (OOD) principles by Robert C. Martin 

- ### Single Responsibility principle
  - There should never be more than one reason for a class to change. 
    A class should only provide focused, specific, single functionality. 
  
```java
// Assume there is a user controller which is response for creating/updating/deleting a user

public class UserController {
    public boolean createUser(User user) {
        // 1. Validate user info like if user email, contact number is correct or not.
        // 2. If USER is valid then Save to DB (persist this info) else return false.
    }
}

// In above example UserController has two responsibilities - validation and persisiting user info.
// This UserController class can change whenever we add a new field in user (example - address). Because we'll need to validate this new field as well.
// Therefore, it is not following single responsibility prince rule.

// This version of UserController is following single responsibility principle
public class UserController {
    private UserPersistenceService persistenceService;
    
    public UserController() {
      UserPersistenceService persistenceService = new UserPersistenceService();
    }
    
    public boolean createUser(User user) {
      UserValidator validator = new UserValidator();
      if(validator.isValid(user)) {
            persistenceService.saveUser(user);
      }else{
          return false;
      }
    }
}

public class UserValidator {
    public boolean isValid(User user) {
        // Validate User
    }
}

public class UserPersistenceService {
    public boolean saveUser(User user) {
        // Save User to DB
    }
}
```