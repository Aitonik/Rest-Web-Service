package ru.aitalina.rest_ws.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.aitalina.rest_ws.model.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDao implements UserDaoInterface{

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserRepo userRepo;


    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        return (List<User>)entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepo.findUserByLogin(login);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(findUserById(id));
    }
}
