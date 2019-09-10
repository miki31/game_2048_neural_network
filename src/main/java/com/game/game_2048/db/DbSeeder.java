package com.game.game_2048.db;

import com.game.game_2048.model.User;
import com.game.game_2048.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new ArrayList<>();
        User user;

        user = new User(
                "a@com",
                "aaa",
                "A",
                "Z",
                "azaz"
        );
        users.add(user);

        user = new User(
                "b@com",
                "bbb",
                "B",
                "Z",
                "bzbz"
        );
        users.add(user);

        user = new User(
                "c@com",
                "ccc",
                "C",
                "Z",
                "czcz"
        );
        users.add(user);

        //drop all hotels
        this.userRepository.deleteAll();

        // add aur hotels to database
        this.userRepository.saveAll(users);

    }
}
