package ru.netology.one_hundred_and_thirty_second.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.netology.one_hundred_and_thirty_second.models.User;
import ru.netology.one_hundred_and_thirty_second.services.UserServiceImpl;

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


    @GetMapping("new/")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create";
    }


//    это для кнопки
//    @GetMapping("get/")
//    public String selectAll(Model model) {
//        model.addAttribute(userService.getAllUsers);
//        return "index";
//    }
}
