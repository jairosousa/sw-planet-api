package com.jnsdev.swplanetapi.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.jnsdev.swplanetapi.common.PlanetsConstants.INVALID_PLANET;
import static com.jnsdev.swplanetapi.common.PlanetsConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @Autor Jairo Nascimento
 * @Created 03/07/2024 - 10:48
 */
@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;

    // operacao_estado_returno
    @Test
    void createPlanet_withValidData_ReturnsPlanet() {
        // Arrange
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        // ACT
        Planet sut = planetService.create(PLANET);

        // Asserts
        assertThat(sut).isEqualTo(PLANET);

    }

    @Test
    void createPlanet_withInvalidData_ThrowsException() {
        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThatThrownBy(
                () -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void getPlanet_ByExistingId_ReturnPlanet() {
        Long id = 1L;
        when(planetRepository.findById(id)).thenReturn(Optional.of(PLANET));

        // ACT
        Optional<Planet> sut = planetService.get(id);

        // Asserts
        assertThat(sut).isPresent();
        assertThat(sut).isNotEmpty();
        assertThat(sut).contains(PLANET);
    }

    @Test
    void getPlanet_ByUnexistingId_ReturnEmpty() {
        Long id = 1L;
        when(planetRepository.findById(id)).thenReturn(Optional.empty());

        // ACT
        Optional<Planet> sut = planetService.get(id);

        // Asserts
        assertThat(sut).isEmpty();
    }

    @Test
    void getPlanet_ByExistingName_ReturnPlanet() {
        when(planetRepository.findByName(anyString())).thenReturn(Optional.of(PLANET));

        // ACT
        Optional<Planet> sut = planetService.getByName("name");

        // Asserts
        assertThat(sut).isNotEmpty();
        assertThat(sut).contains(PLANET);
    }

    @Test
    void getPlanet_ByUnexitingName_ReturnEmpty() {
        when(planetRepository.findByName(anyString())).thenReturn(Optional.empty());

        // ACT
        Optional<Planet> sut = planetService.getByName("name");

        // Asserts
        assertThat(sut).isEmpty();
    }

    @Test
    void listPlanets_ReturnsAllPlanets() {
        List<Planet> planets = new ArrayList<>() {{
            add(PLANET);
        }};

        Example<Planet> query = QueryBuilder.makeQuery(new Planet(PLANET.getClimate(), PLANET.getTerrain()));
        when(planetRepository.findAll(query)).thenReturn(planets);

        List<Planet> sut = planetService.list(PLANET.getClimate(), PLANET.getTerrain());
        assertThat(sut).isNotEmpty();
        assertThat(sut).hasSize(1);
        assertThat(sut.get(0)).isEqualTo(PLANET);

    }

    @Test
    void listPlanets_ReturnsNoPlanets() {
        when(planetRepository.findAll(any())).thenReturn(Collections.emptyList());

        List<Planet> sut = planetService.list(PLANET.getClimate(), PLANET.getTerrain());

        assertThat(sut).isEmpty();
    }
}