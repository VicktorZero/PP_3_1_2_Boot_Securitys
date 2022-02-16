package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;


public interface RoleService {
     Set<Role> getAllRoles();
     Role getRole(Long id);
     Role findRoleByName(String name);
     void deleteRole(Long id);
}
