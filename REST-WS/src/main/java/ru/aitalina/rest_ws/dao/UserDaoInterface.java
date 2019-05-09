package ru.aitalina.rest_ws.dao;

import ru.aitalina.rest_ws.model.User;

import java.util.List;

public interface UserDaoInterface {

    List<User> findAllUsers();

    User findUserById(Long id);

    User findUserByLogin(String login);

    void saveUser(User user);

    void deleteUser(Long id);
}
