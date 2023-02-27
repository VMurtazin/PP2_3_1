package ru.murtazin.crud.dao;


import ru.murtazin.crud.model.User;

import java.util.List;


public interface UserDao {

    List<User> getAllUsers();
    void add(User user);
    void delete(int id);
    void edit(User updatedUser);
    User getById(int id);
}
