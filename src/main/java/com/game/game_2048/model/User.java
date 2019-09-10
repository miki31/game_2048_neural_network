package com.game.game_2048.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

@Data
@Document(collection = "Users")
public class User {

    @Id
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String nikName;
    private List<Role> roles;

    public User() {
    }

    public User(String id,
                String email,
                String password,
                String firstName,
                String lastName,
                String nikName,
                List<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nikName = nikName;
        this.roles = roles;
    }

    public User(String email,
                String password,
                String firstName,
                String lastName,
                String nikName,
                List<Role> roles) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nikName = nikName;
        this.roles = roles;
    }
}
