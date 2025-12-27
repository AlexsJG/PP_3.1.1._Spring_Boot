package com.Spring.dao;

import com.Spring.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }


    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public User updateUser(int id) {
        Query query = entityManager.createQuery("SELECT u FROM User u where id =:userId");
        query.setParameter("userId", id);
        return (User) query.getSingleResult();
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("DELETE FROM User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
