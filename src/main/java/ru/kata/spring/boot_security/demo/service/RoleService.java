package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

     Role getRole(Long id);
     Role findRoleByName(String name);
     void deleteRole(Long id);
}
