package com.jnsdev.swplanetapi.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.jnsdev.swplanetapi.common.PlanetsConstants.INVALID_PLANET;
import static com.jnsdev.swplanetapi.common.PlanetsConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
}