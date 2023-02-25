package ru.murtazin.crud.service;

import ru.murtazin.crud.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void add(User user);
    void delete(int id);
    void edit(User updatedUser);
    User getById(int id);
}
