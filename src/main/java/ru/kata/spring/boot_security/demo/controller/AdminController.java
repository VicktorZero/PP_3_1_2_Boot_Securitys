package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dao.RoleService;
import ru.kata.spring.boot_security.demo.dao.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Collections;

@Controller
@RequestMapping
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/admin")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id,Model model){
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user,
                            @PathVariable("id") Long id) {
     userService.updateUser(id, user);
     return "redirect:/admin";
    }
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}
