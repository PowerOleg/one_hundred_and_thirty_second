package ru.netology.one_hundred_and_thirty_second.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.netology.one_hundred_and_thirty_second.models.User;
import ru.netology.one_hundred_and_thirty_second.services.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private UserServiceImpl userServiceImpl;

    public UserController() {
    }

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping
    public String selectAll(Model model) {
        model.addAttribute("users", userServiceImpl.getAll());
        return "index";
    }

    @PostMapping
    public String selectAll(@ModelAttribute("user") User user) {
        userServiceImpl.save(user);
        return "redirect:/";
    }

    @GetMapping("new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create";
    }

    @PostMapping("findOne")
    public String selectByName(@RequestParam String name, Model model) {
        List<User> users = userServiceImpl.getAll();
        model.addAttribute("users", users.stream().filter(n -> n.getName().equalsIgnoreCase(name)));
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.delete(id);
        return "redirect:/";
    }

    @GetMapping("update")
    public String updateUser(User user) {
        return "update";
    }

    @PostMapping("/update")
    public String updateUserForm(@ModelAttribute("user") User user) {
        List<User> users = userServiceImpl.getAll();
        users.replaceAll(n -> {
            if (n.getId().equals(user.getId())) {
                return user;
            }
            return n;
        });


        userServiceImpl.deleteAll();
        for (User user1 : users) {
            userServiceImpl.save(user1);
        }
        return "redirect:/";
    }
}
