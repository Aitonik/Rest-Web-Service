package ru.aitalina.rest_ws.dao;

import org.springframework.stereotype.Repository;
import ru.aitalina.rest_ws.model.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class RoleDao implements RoleDaoInterface{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public UserRole findUserRoleByRole(String role) {
        return entityManager.find(UserRole.class, role);
    }
}
