package pl.edu.wat.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.backend.api.User;
import pl.edu.wat.backend.jpa.UserEntity;
import pl.edu.wat.backend.repositories.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public void add(User user) {
        UserEntity entity = UserEntity.builder()
                .email(user.getEmail())
                .first_name(user.getFirst_name())
                .last_name(user.getLast_name())
                .phone_number(user.getPhone_number())
                .password(user.getPassword())
                .build();
        repository.save(entity);
    }

    @Override
    public void delete(int userId) {
        repository.deleteById(userId);
    }

    @Override
    public Set<User> getAllUsers() {
        return StreamSupport.stream(repository.findAll().spliterator(),false)
                .map(userEntity -> User.builder()
                .first_name(userEntity.getFirst_name())
                .last_name(userEntity.getLast_name())
                .email(userEntity.getEmail())
                .id(userEntity.getId())
                .phone_number(userEntity.getPhone_number())
                .password(userEntity.getPassword())
                .build()).collect(Collectors.toSet());
    }
}
