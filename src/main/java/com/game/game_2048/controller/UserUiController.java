package com.game.game_2048.controller;

import com.game.game_2048.model.User;
import com.game.game_2048.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserUiController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String findAll(){
        List<User> users = userService.findAll();
        String usersStr = "";
        for (User user:
             users) {
            usersStr = usersStr + " " + user.getFirstName();
        }
        return "home";
    }
}
