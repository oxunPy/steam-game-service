package org.example.steamgameservice.controller;

import org.example.steamgameservice.entity.Game;
import org.example.steamgameservice.repository.GameRepository;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/steam-game")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Create a new game
    @PostMapping("/create-new")
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    // Get all games
    @GetMapping("/all")
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    // Get a single game by ID
    @GetMapping("/{id}")
    public Optional<Game> getGameById(@PathVariable String id) {
        return gameRepository.findById(id);
    }

    // Search games by title
    @GetMapping("/search")
    public List<Game> searchGames(@RequestParam String title) {
        return gameRepository.findByTitleContainingIgnoreCase(title);
    }

    // Delete a game
    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        gameRepository.deleteById(id);
    }

    // Stream game title video
    @GetMapping("/stream/{videoPath}")
    public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) throws FileNotFoundException {
        File file = new File(videoPath);
        if(file.exists()) {
            InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("video/mp4"))
                    .body(inputStreamResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
