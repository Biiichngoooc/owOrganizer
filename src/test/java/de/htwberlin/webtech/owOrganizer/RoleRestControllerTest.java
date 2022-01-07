package de.htwberlin.webtech.owOrganizer;

import de.htwberlin.webtech.owOrganizer.service.RoleService;
import de.htwberlin.webtech.owOrganizer.web.RoleRestController;
import de.htwberlin.webtech.owOrganizer.web.api.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoleRestController.class)
public class RoleRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @Test
    @DisplayName("should return found roles from role service")
    void should_return_found_role_from_role_service() throws Exception {
        var roles = List.of(
                new Role(1, "Offtank", "Dva, Sigma", 3150, 6),
                new Role(2, "Main Support", "Brig, Mercy, Ana, Bap", 4250, 6)
        );
        doReturn(roles).when(roleService).findAll();

        mockMvc.perform(get("/api/v1/roles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].role").value("Offtank"))
                .andExpect(jsonPath("$[0].heropool").value("Dva, Sigma"))
                .andExpect(jsonPath("$[0].peakSr").value(3150))
                .andExpect(jsonPath("$[0].playerId").value(6))
                .andExpect(jsonPath("$[1].role").value("Main Support"))
                .andExpect(jsonPath("$[1].heropool").value("Brig, Mercy, Ana, Bap"))
                .andExpect(jsonPath("$[1].peakSr").value(4250))
                .andExpect(jsonPath("$[1].playerId").value(6));
    }

    @Test
    @DisplayName("should return 404 if role is not found")
    void should_return_404_if_role_is_not_found() throws Exception {
        doReturn(null).when(roleService).findById(anyInt());

        mockMvc.perform(get("/api/v1/roles/100"))
                .andExpect(status().isNotFound());
    }

}
