package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Transactional
public class RoleServiceImpl implements RoleService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Set<Role> getAllRoles() {
        List<Role> listRole = entityManager.createQuery("from Role", Role.class).getResultList();
        Set<Role> roles = new HashSet<>(listRole);
        return roles;
    }

    @Override
    public Role getRole(Long id) {
        return entityManager.find(Role.class,id);
    }

    @Override
    public Role findRoleByName(String name) {
        return entityManager.createQuery("SELECT u FROM Role u WHERE u.name=:name",Role.class).getSingleResult();
    }

    @Override
    public void deleteRole(Long id) {
        entityManager.remove(entityManager.find(Role.class,id));
    }
}
