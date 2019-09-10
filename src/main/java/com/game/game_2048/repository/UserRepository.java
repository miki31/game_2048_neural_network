package com.game.game_2048.repository;

import com.game.game_2048.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    @Override
    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);
}
