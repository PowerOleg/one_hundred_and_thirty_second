package ru.netology.one_hundred_and_thirty_second.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.one_hundred_and_thirty_second.database.repositories.UserRepository;
import ru.netology.one_hundred_and_thirty_second.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        return optUser.orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
