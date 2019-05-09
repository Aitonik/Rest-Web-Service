package ru.aitalina.rest_ws.service;

import ru.aitalina.rest_ws.model.User;

import java.util.List;

public interface UserServiceInterface {

    List<User> findAllUsers();

    User findUserById(Long id);

    User findUserByLogin(String login);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
