package com.jnsdev.swplanetapi.domain;

import com.jnsdev.swplanetapi.common.PlanetsConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.jnsdev.swplanetapi.common.PlanetsConstants.PLANET;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Autor Jairo Nascimento
 * @Created 03/07/2024 - 10:48
 */
@SpringBootTest(classes = PlanetService.class)
class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;

    // operacao_estado_returno
    @Test
    void createPlanet_withValiData_ReturnsPlanet() {
        Planet sut = planetService.create(PLANET);

        Assertions.assertThat(sut).isEqualTo(PLANET);

    }

}