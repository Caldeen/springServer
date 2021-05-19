package pl.edu.wat.backend.services;

import pl.edu.wat.backend.api.User;
import pl.edu.wat.backend.jpa.UserEntity;

import java.util.Set;

public interface UserService {
    void add(User user);
    void delete(int userId);
    Set<User> getAllUsers();

}
