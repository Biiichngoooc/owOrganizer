package de.htwberlin.webtech.owOrganizer.web;

import de.htwberlin.webtech.owOrganizer.web.api.Player;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OwOrganizerController {

    @GetMapping(path = "/")
    public ModelAndView showTeamPage(){
            return new ModelAndView("uniligateam");

    }
}
