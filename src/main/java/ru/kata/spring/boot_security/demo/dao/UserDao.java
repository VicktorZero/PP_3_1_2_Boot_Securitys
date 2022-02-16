package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
     List<User> getAllUsers();
//     Set<Role> getAllRoles();
     void saveUser(User user);
     void deleteUser(Long id);
     User findById(Long id);
     User updateUser(Long id, User user);


}
