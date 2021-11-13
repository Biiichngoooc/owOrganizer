package de.htwberlin.webtech.owOrganizer.web;

import de.htwberlin.webtech.owOrganizer.web.api.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerRestController {

    private List<Player> players;

    public PlayerRestController() {
        players = new ArrayList<>();
        players.add(new Player(1, "Max", "a1", "max#123", "male", "Max",
                "Mustermann"));
        players.add(new Player(2, "Maria", "a2", "maria#456", "female", "Maria",
                "Mustermann"));
    }

    @GetMapping(path = "/api/v1/players" )
    public ResponseEntity<List<Player>> fetchPlayers() {
        return ResponseEntity.ok(players);
    }

}


