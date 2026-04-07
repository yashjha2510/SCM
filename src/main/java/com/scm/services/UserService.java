package com.scm.services;

import java.util.List;
import com.scm.entities.User;

public interface UserService {
    User saveUser(User user);
    User getUserById(String id);
    void deleteUser(String id);
    User updateUser(User user);
    boolean isUserExists(String userId);
    boolean isUserExistsByEmail(String email);
    list<User> getAllUsers();
}
