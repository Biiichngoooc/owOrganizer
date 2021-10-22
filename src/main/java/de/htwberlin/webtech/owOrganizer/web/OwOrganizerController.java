package de.htwberlin.webtech.owOrganizer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OwOrganizerController {

    @GetMapping(path = "/")
    public ModelAndView showTeamPage(){
            return new ModelAndView("uniligateam");

    }
}
