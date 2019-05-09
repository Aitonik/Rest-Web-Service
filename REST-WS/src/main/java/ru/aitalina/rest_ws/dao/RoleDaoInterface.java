package ru.aitalina.rest_ws.dao;

import ru.aitalina.rest_ws.model.UserRole;

public interface RoleDaoInterface {

    UserRole findUserRoleByRole(String role);
}
