package com.jnsdev.swplanetapi.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.jnsdev.swplanetapi.common.PlanetsConstants.INVALID_PLANET;
import static com.jnsdev.swplanetapi.common.PlanetsConstants.PLANET;
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
        Assertions.assertThat(sut).isEqualTo(PLANET);

    }

    @Test
    void createPlanet_withInvalidData_ThrowsException() {
        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThatThrownBy(
                () -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

}