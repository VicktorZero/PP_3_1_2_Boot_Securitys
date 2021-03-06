package ru.kata.spring.boot_security.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User",User.class).getResultList();
    }


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class,id));

    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User updateUser(Long id, User user) {
        User update = findById(id);
        update.setFirstname(user.getFirstname());
        update.setEmail(user.getEmail());
        return entityManager.merge(update);
    }


}
