package ru.murtazin.crud.dao;


import org.springframework.stereotype.Repository;
import ru.murtazin.crud.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(User updatedUser) {

    }

    @Override
    public User getById(int id) {
        return null;
    }
}
