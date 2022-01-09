package de.htwberlin.webtech.owOrganizer;

import de.htwberlin.webtech.owOrganizer.service.UniligaTeamService;
import de.htwberlin.webtech.owOrganizer.web.UniligaTeamRestController;
import de.htwberlin.webtech.owOrganizer.web.api.Player;
import de.htwberlin.webtech.owOrganizer.web.api.UniligaTeam;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.AsyncServerResponse.create;

@WebMvcTest(UniligaTeamRestController.class)
public class UniligaTeamRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UniligaTeamService uniligaTeamService;

    @Test
    @DisplayName("should return found uniliga Team from uniligaTeam service")
    void should_return_found_uniliga_Team_from_uniligaTeam_service() throws Exception {
        var uniligaTeams = List.of(
                new UniligaTeam(1, "Berlin Gummibär", "Technische Universität Berlin"),
                new UniligaTeam(2, "Berlin Pommes Schranke", "Hochschule für Technik und Wirtschaft Berlin")
        );
        doReturn(uniligaTeams).when(uniligaTeamService).findAll();

        mockMvc.perform(get("/api/v1/uniligaTeams"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Berlin Gummibär"))
                .andExpect(jsonPath("$[0].uni").value("Technische Universität Berlin"))
                .andExpect(jsonPath("$[1].name").value("Berlin Pommes Schranke"))
                .andExpect(jsonPath("$[1].uni").value("Hochschule für Technik und Wirtschaft Berlin"));
    }

    @Test
    @DisplayName("should return 404 if uniliga team is not found")
    void should_return_404_if_uniliga_team_is_not_found() throws Exception {
        doReturn(null).when(uniligaTeamService).findByUni(anyString());

        mockMvc.perform(get("/api/v1/uniligaTeams/HTW"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating an uniliga team")
    void should_return_201_http_status_and_location_header_when_creatin_an_uniliga_team() throws Exception {
        String playerToCreateAsJson ="{\"name\": \"Berlin Gummibär\",\n" +
                "        \"uni\": \"Technische Universität Berlin}";

        var uniligaTeam = new UniligaTeam(100,null,null);

        doReturn(uniligaTeam).when(uniligaTeamService).create(any());

        mockMvc.perform(
                        post("/api/v1/uniligaTeams")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(playerToCreateAsJson)
                )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo("/api/v1/uniligaTeams/" + uniligaTeam.getId())));

    }
}
