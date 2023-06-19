package com.app.controller;

import com.app.service.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/if-unless")
    public String users(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("Dima", "dkid555@gmail.com", "ADMIN"));
        users.add(new User("Andrey", "Andy@gmail.com", "USER"));
        users.add(new User("Tatiana", "Tati@gmail.com", "USER"));
        users.add(new User("Irina", "IRA@gmail.com", "USER"));
        model.addAttribute("users", users);
        return "if-unless";
    }

    @RequestMapping("/switch-case")
    public String switchEx(Model model) {
        User user = new User("Dima", "dkid555@gmail.com", "ADMIN");
        model.addAttribute("user", user);
        return "switch-case";
    }
}
