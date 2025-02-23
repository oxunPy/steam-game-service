package org.example.steamgameservice.service;

import lombok.RequiredArgsConstructor;
import org.example.steamgameservice.entity.Game;
import org.example.steamgameservice.entity.Review;
import org.example.steamgameservice.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public List<Game> getTopRatedGames() {
        return gameRepository.findGamesWithRatingGreaterThan(7);
    }

    public Game addReview(String gameId, Review review) {
        Game game = gameRepository.findById(gameId).orElseThrow();
        game.getReviews().add(review);
        return game;
    }
}
