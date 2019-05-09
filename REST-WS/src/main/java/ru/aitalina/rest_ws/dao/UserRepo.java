package ru.aitalina.rest_ws.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aitalina.rest_ws.model.User;

public interface UserRepo extends JpaRepository<User, String> {

    User findUserByLogin(String login);
}
