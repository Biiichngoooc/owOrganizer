package de.htwberlin.webtech.owOrganizer.web;

import de.htwberlin.webtech.owOrganizer.persistence.IUniligaTeamRepository;
import de.htwberlin.webtech.owOrganizer.service.UniligaTeamService;
import de.htwberlin.webtech.owOrganizer.web.api.PlayerManipulationRequest;
import de.htwberlin.webtech.owOrganizer.web.api.UniligaTeam;
import de.htwberlin.webtech.owOrganizer.web.api.UniligaTeamManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UniligaTeamRestController {

    private final UniligaTeamService uniligaTeamService;

    public UniligaTeamRestController(UniligaTeamService uniligaTeamService) {
        this.uniligaTeamService = uniligaTeamService;
    }

    @GetMapping(path = "/api/v1/uniligaTeams")
    public ResponseEntity<List<UniligaTeam>> fetchUniligaTeams(){
        return ResponseEntity.ok(uniligaTeamService.findAll());
    }
    @GetMapping(path = "/api/v1/unligaTeams/{id}")
    public ResponseEntity<UniligaTeam> fetchTeamsById(@PathVariable Integer id){
        var uniligaTeam = uniligaTeamService.findById(id);
        return uniligaTeam != null? ResponseEntity.ok(uniligaTeam) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "api/v1/uniligaTeams/{uni}")
    public ResponseEntity<List<UniligaTeam>> fetchTeamsByUni(@PathVariable String uni){
        var uniligaTeam = uniligaTeamService.findByUni(uni);
        return uniligaTeam != null ? ResponseEntity.ok(uniligaTeam) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/uniligaTeams")
    public ResponseEntity<Void> createUniligaTeam(@RequestBody UniligaTeamManipulationRequest request) throws URISyntaxException{
        var uniligaTeam = uniligaTeamService.create(request);
        URI uri = new URI("api/v1/uniligaTeams/" + uniligaTeam.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping (path = "/api/v1/uniligaTeams/{id}")
    public ResponseEntity<UniligaTeam> updateUniligaTeam(@PathVariable Integer id,
                                                         @RequestBody UniligaTeamManipulationRequest request){
        var uniligaTeam = uniligaTeamService.update(id, request);
        return uniligaTeam != null? ResponseEntity.ok(uniligaTeam) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/uniligaTeams/{id}")
    public ResponseEntity<Void> deleteUniligaTeam(@PathVariable Integer id){
        boolean successful = uniligaTeamService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
