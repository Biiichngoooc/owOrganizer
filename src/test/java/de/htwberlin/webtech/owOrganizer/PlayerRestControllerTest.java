package de.htwberlin.webtech.owOrganizer;

import de.htwberlin.webtech.owOrganizer.service.PlayerService;
import de.htwberlin.webtech.owOrganizer.web.PlayerRestController;
import de.htwberlin.webtech.owOrganizer.web.api.Player;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(PlayerRestController.class)
public class PlayerRestControllerTest {
     @Autowired
    private MockMvc mockMvc;

     @MockBean
    private PlayerService playerService;

    @Test
    @DisplayName("should return found players from player service")
    void should_return_found_players_from_player_service() throws Exception {
         var players = List.of(
                 new Player(1,"jk11", "Jack#11", "Jackie#12",
                         "male", "Jack", "Müller", Date.valueOf("1996-12-11"), true, true,
                         "Jackie@gmail.com", "HTW Berlin", "Berlin", true, "Jackie@htw-berlin.de" ),
                new Player(2,"marie11", "Marie#11", "Marie#12",
                        "female", "Marie", "Meier", Date.valueOf("1997-07-01"), true, false,
                        "Marie@gmail.com", "HTW Berlin", "Berlin", true, "Marie@htw-berlin.de" )
         );
         doReturn(players).when(playerService).findAll();

         mockMvc.perform(get("/api/v1/players"))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.size()").value(2))
                 .andExpect(jsonPath("$[0].playerName").value("jk11"))
                 .andExpect(jsonPath("$[0].bnetId").value("Jack#11"))
                 .andExpect(jsonPath("$[0].discordTag").value("Jackie#12"))
                 .andExpect(jsonPath("$[0].gender").value("male"))
                 .andExpect(jsonPath("$[0].firstName").value("Jack"))
                 .andExpect(jsonPath("$[0].lastName").value("Müller"))
                 .andExpect(jsonPath("$[0].birthday").value("11.12.1996"))
                 .andExpect(jsonPath("$[0].isStudent").value(true))
                 .andExpect(jsonPath("$[0].isCompetitive").value(true))
                 .andExpect(jsonPath("$[0].bnetMail").value("Jackie@gmail.com"))
                 .andExpect(jsonPath("$[0].uni").value("HTW Berlin"))
                 .andExpect(jsonPath("$[0].cityOfResidence").value("Berlin"))
                 .andExpect(jsonPath("$[0].owned").value(true))
                 .andExpect(jsonPath("$[0].uniMail").value("Jackie@htw-berlin.de"))
                 .andExpect(jsonPath("$[1].playerName").value("marie11"))
                 .andExpect(jsonPath("$[1].bnetId").value("Marie#11"))
                 .andExpect(jsonPath("$[1].discordTag").value("Marie#12"))
                 .andExpect(jsonPath("$[1].gender").value("female"))
                 .andExpect(jsonPath("$[1].firstName").value("Marie"))
                 .andExpect(jsonPath("$[1].lastName").value("Meier"))
                 .andExpect(jsonPath("$[1].birthday").value("01.07.1997"))
                 .andExpect(jsonPath("$[1].isStudent").value(true))
                 .andExpect(jsonPath("$[1].isCompetitive").value(false))
                 .andExpect(jsonPath("$[1].bnetMail").value("Jackie@gmail.com"))
                 .andExpect(jsonPath("$[1].uni").value("HTW Berlin"))
                 .andExpect(jsonPath("$[1].cityOfResidence").value("Berlin"))
                 .andExpect(jsonPath("$[1].owned").value(true))
                 .andExpect(jsonPath("$[0].uniMail").value("Marie@htw-berlin.de"));
     }


    @Test
    @DisplayName("should return 404 if player is not found")
    void should_return_404_if_player_is_not_found() throws Exception {
        doReturn(null).when(playerService).findById(anyInt());

        mockMvc.perform(get("/api/v1/players/100"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 http status and Location header when creating a player")
    void should_return_201_http_status_and_location_header_when_creatin_a_player() throws Exception {
        String playerToCreateAsJson ="{\"playerName\": \"Rosie\",\n" +
                "    \"bnetId\": \"Rose99#2219\",\n" +
                "    \"discordTag\": \"Rosie#1241\",\n" +
                "    \"gender\": \"f\",\n" +
                "    \"firstName\": \"Rose\",\n" +
                "    \"lastName\": \"Kraus\",\n" +
                "    \"birthday\": \"1996-12-16\",\n" +
                "    \"student\": true,\n" +
                "    \"competitive\": true}";

        var player = new Player(100,null,null,null,null,null,
                null, null, false, false, null, null, null,
                true, null);

        doReturn(player).when(playerService).create(any());

        mockMvc.perform(
                post("/api/v1/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(playerToCreateAsJson)
        )
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo("/api/v1/players/" + player.getId())));

    }

    @Test
    @DisplayName("should validate create player request")
    void should_validate_create_player_request() throws Exception {
        String playerToCreateAsJson = "{\"playerName\": \"Rose\",\n" +
                "    \"bnetId\": \"\",\n" +
                "    \"discordTag\": \"\",\n" +
                "    \"gender\": \"\",\n" +
                "    \"firstName\": \"\",\n" +
                "    \"lastName\": \"\",\n" +
                "    \"birthday\": \"\",\n" +
                "    \"student\": true,\n" +
                "    \"competitive\": true}";
        mockMvc.perform(
                        post("/api/v1/players")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(playerToCreateAsJson)
                )
                .andExpect(status().isBadRequest());
    }
}

