package de.htwberlin.webtech.owOrganizer.web;

import de.htwberlin.webtech.owOrganizer.service.StudentPlayerService;
import de.htwberlin.webtech.owOrganizer.web.api.StudentPlayer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentPlayerRestController {
    private final StudentPlayerService studentPlayerService;

    public StudentPlayerRestController(StudentPlayerService studentPlayerService){this.studentPlayerService = studentPlayerService;}

    @GetMapping(path = "/api/v1/studentPlayers")
    public ResponseEntity<List<StudentPlayer>> fetchPlayers(){
        return ResponseEntity.ok(studentPlayerService.findAll());
    }
}
