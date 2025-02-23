package org.example.steamgameservice.repository;

import org.example.steamgameservice.entity.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GameRepository extends MongoRepository<Game, String> {

    List<Game> findByTitleContainingIgnoreCase(String title);
    List<Game> findByGenresContaining(String genre);
}
