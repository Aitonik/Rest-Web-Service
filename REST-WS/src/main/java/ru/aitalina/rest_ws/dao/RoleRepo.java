package ru.aitalina.rest_ws.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aitalina.rest_ws.model.UserRole;

import java.util.List;

public interface RoleRepo extends JpaRepository<UserRole, String > {
    UserRole findUserRoleByRole(String role);

    @Override
    List<UserRole> findAll();
}
