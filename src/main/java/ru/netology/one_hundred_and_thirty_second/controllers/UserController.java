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


    @GetMapping("new")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create";
    }


//доделать
    @PostMapping("findOne")
    @ResponseBody
    public String selectAll(@RequestParam String name) {
        System.out.println(name);
        return "You requested the parameter " + name;
    }




    @GetMapping("delete/{id}")
    public String selectAll(@PathVariable Long id) {
        userServiceImpl.getById(id);
        return "redirect:/";
    }

    //доделать
    @GetMapping ("user-update" )
    public String updateUser (User user){
//        нужно удалить и сохранить видимо, но лучше реализовать нормальный метод ....update из коробки
//        userServiceImpl.save(user);
//        return "redirect:/" ;
        return "update" ;
    }
}
