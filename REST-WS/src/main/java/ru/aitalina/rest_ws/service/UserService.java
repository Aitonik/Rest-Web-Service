package ru.aitalina.rest_ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aitalina.rest_ws.dao.RoleDaoInterface;
import ru.aitalina.rest_ws.dao.UserDaoInterface;
import ru.aitalina.rest_ws.model.User;
import ru.aitalina.rest_ws.model.UserRole;

import java.util.List;

@Service("userService")
public class UserService implements UserServiceInterface{

    @Autowired
    UserDaoInterface userDaoInterface;

    @Autowired
    RoleDaoInterface roleDaoInterface;


    @Override
    public List<User> findAllUsers() {
        return userDaoInterface.findAllUsers();
    }

    @Override
    public User findUserById(Long id) {
        return userDaoInterface.findUserById(id);
    }

    @Override
    public User findUserByLogin(String login) {
        return userDaoInterface.findUserByLogin(login);
    }

    @Override
    public void saveUser(User user) {
        userDaoInterface.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDaoInterface.saveUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDaoInterface.deleteUser(id);
    }

    public UserRole findUserRoleByRole(String role) {
        return roleDaoInterface.findUserRoleByRole(role);
    }
}
