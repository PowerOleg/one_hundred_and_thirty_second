package ru.netology.one_hundred_and_thirty_second.services;

import ru.netology.one_hundred_and_thirty_second.models.User;

import java.util.List;

public interface UserService {
    User getById(Long id);
    void save(User user);
    void delete(Long id);
    List<User> getAll();
    void deleteAll();

}
