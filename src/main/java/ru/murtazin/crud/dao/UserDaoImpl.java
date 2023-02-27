package ru.murtazin.crud.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.murtazin.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Query query = entityManager.createNativeQuery("select * from users", User.class);
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public void add(User user) {

        entityManager.persist(user);
    }

    @Override
    public void delete(int id) {

        User user=entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    @Override
    public void edit(User updatedUser) {

        entityManager.merge(updatedUser);
    }

    @Override
    public User getById(int id) {

        return entityManager.find(User.class,id);
    }
}
