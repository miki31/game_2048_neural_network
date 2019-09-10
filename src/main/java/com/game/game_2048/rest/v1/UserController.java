package com.game.game_2048.rest.v1;

import com.game.game_2048.model.User;
import com.game.game_2048.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> findAll(){
        List<User> users = userService.findAll();
        return users;
//        String usersStr = "";
//        for (User user:
//                users) {
//            usersStr = usersStr + " " + user.getFirstName();
//        }
//        return usersStr;
    }
}
