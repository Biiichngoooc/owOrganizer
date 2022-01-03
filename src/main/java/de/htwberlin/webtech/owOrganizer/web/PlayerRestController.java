package de.htwberlin.webtech.owOrganizer.web;

import de.htwberlin.webtech.owOrganizer.service.PlayerService;
import de.htwberlin.webtech.owOrganizer.web.api.Player;
import de.htwberlin.webtech.owOrganizer.web.api.PlayerManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PlayerRestController {
    private final PlayerService playerService;

    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "/api/v1/players" )
    public ResponseEntity<List<Player>> fetchPlayers() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping(path = "/api/v1/players/{id}")
    public ResponseEntity<Player> fetchPlayerById(@PathVariable Integer id) {
        var player = playerService.findById(id);
        return player != null? ResponseEntity.ok(player) : ResponseEntity.notFound().build();
    }

   @PostMapping(path = "/api/v1/players")
    public ResponseEntity<Void> createPlayer(@Valid @RequestBody PlayerManipulationRequest request) throws URISyntaxException{
            var player = playerService.create(request);
            URI uri = new URI("api/v1/players/" + player.getId());
            return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/players/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody PlayerManipulationRequest request) {
        var player = playerService.update(id, request);
        return player != null? ResponseEntity.ok(player) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/players/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id){
        boolean successful = playerService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}


