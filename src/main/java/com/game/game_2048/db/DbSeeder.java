package com.game.game_2048.db;

import com.game.game_2048.model.Role;
import com.game.game_2048.model.User;
import com.game.game_2048.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new ArrayList<>();
        User user;

        user = new User(
                "a@com",
                bCryptPasswordEncoder.encode("aaa"),
                "A",
                "Z",
                "azaz",
                Arrays.asList(Role.SUPER_ADMIN, Role.ADMIN)
        );
        users.add(user);

        user = new User(
                "b@com",
                bCryptPasswordEncoder.encode("bbb"),
                "B",
                "Z",
                "bzbz",
                Arrays.asList(Role.ADMIN)
        );
        users.add(user);

        user = new User(
                "c@com",
                bCryptPasswordEncoder.encode("ccc"),
                "C",
                "Z",
                "czcz",
                Arrays.asList(Role.USER)
        );
        users.add(user);

        //drop all hotels
        this.userRepository.deleteAll();

        // add aur hotels to database
        this.userRepository.saveAll(users);

    }


}
