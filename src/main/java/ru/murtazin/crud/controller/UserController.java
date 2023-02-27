package ru.murtazin.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.murtazin.crud.model.User;
import ru.murtazin.crud.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showAllUsers(Model model) {

        List<User> listUsers = userService.getAllUsers();
        model.addAttribute("allUsers",listUsers);
        return "user/index";
    }
}
