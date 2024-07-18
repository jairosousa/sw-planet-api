package com.jnsdev.swplanetapi.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jnsdev.swplanetapi.domain.Planet;
import com.jnsdev.swplanetapi.domain.PlanetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.jnsdev.swplanetapi.common.PlanetsConstants.PLANET;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @Autor Jairo Nascimento
 * @Created 18/07/2024 - 11:08
 */
@WebMvcTest(PlanetController.class)
class PlanetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PlanetService planetService;

    @Test
    void createPlanet_withValidData_ReturnsCreated() throws Exception {

        when(planetService.create(PLANET)).thenReturn(PLANET);

        mockMvc
                .perform(post("/planets")
                        .content(objectMapper.writeValueAsString(PLANET))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").value(PLANET));
    }

    @Test
    void createPlanet_withInvalidData_ReturnsBadRequest() throws Exception {
        Planet emptyPlanet = new Planet();
        Planet invalidPlanet = new Planet("", "", "");

        mockMvc
                .perform(post("/planets")
                        .content(objectMapper.writeValueAsString(emptyPlanet))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
        mockMvc
                .perform(post("/planets")
                        .content(objectMapper.writeValueAsString(invalidPlanet))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void createPlanet_withExistingName_ReturnsConflict() throws Exception {
        when(planetService.create(any())).thenThrow(DataIntegrityViolationException.class);
        mockMvc
                .perform(post("/planets")
                        .content(objectMapper.writeValueAsString(PLANET))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isConflict());
    }

    @Test
    void getPlanet_ByExistingId_ReturnsPlanet() throws Exception {
        when(planetService.get(1L)).thenReturn(Optional.of(PLANET));
        mockMvc
                .perform(get("/planets/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(PLANET));
    }

    @Test
    void getPlanet_ByUnexistingId_ReturnsNotFound() throws Exception {
        mockMvc
                .perform(get("/planets/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getPlanet_ByExistingName_ReturnPlanet() throws Exception {
        when(planetService.getByName(PLANET.getName())).thenReturn(Optional.of(PLANET));
        mockMvc
                .perform(get("/planets/name/" + PLANET.getName()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(PLANET));
    }

    @Test
    void getPlanet_ByUnexistingName_ReturnEmpty() throws Exception {
        mockMvc
                .perform(get("/planets/name/" + PLANET.getName()))
                .andExpect(status().isNotFound());
    }
}