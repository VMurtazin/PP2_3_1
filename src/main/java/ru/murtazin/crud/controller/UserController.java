package ru.murtazin.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/{id}")
    public String user(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user/oneuser";
    }

    @GetMapping("/new")
    public String newUser(Model model ) {
        model.addAttribute("newuser",new User());
        return "user/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("newuser")User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")int id,Model model){
        model.addAttribute("user",userService.getById(id));
        return "/user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user")User user){
        userService.edit(user);
        return "redirect:/users";
    }
}
