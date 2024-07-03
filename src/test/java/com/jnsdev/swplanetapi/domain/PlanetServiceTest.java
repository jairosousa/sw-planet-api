package com.jnsdev.swplanetapi.domain;

import com.jnsdev.swplanetapi.common.PlanetsConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.jnsdev.swplanetapi.common.PlanetsConstants.PLANET;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @Autor Jairo Nascimento
 * @Created 03/07/2024 - 10:48
 */
//@SpringBootTest(classes = PlanetService.class)
@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    //    @MockBean
    @Mock
    private PlanetRepository planetRepository;

    // operacao_estado_returno
    @Test
    void createPlanet_withValiData_ReturnsPlanet() {
        // Arrange
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        // ACT
        Planet sut = planetService.create(PLANET);

        // Asserts
        Assertions.assertThat(sut).isEqualTo(PLANET);

    }

}