package com.jnsdev.swplanetapi.domain;

import com.jnsdev.swplanetapi.common.PlanetsConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static com.jnsdev.swplanetapi.common.PlanetsConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @Autor Jairo Nascimento
 * @Created 18/07/2024 - 09:48
 */
@DataJpaTest
class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void createPlanet_WithValidData_ReturnsPlanet() {
        Planet planet = planetRepository.save(PLANET);

        Planet sut = testEntityManager.find(Planet.class, planet.getId());

        System.out.println(sut);

        assertThat(sut).isNotNull();
        assertThat(sut.getId()).isEqualTo(planet.getId());
        assertThat(sut.getName()).isEqualTo(PLANET.getName());
        assertThat(sut.getClimate()).isEqualTo(PLANET.getClimate());
        assertThat(sut.getTerrain()).isEqualTo(PLANET.getTerrain());
    }

    @Test
    void createPlanet_WithInvalidData_ThrowsException() {
        Planet emptyPlanet = new Planet();
        Planet invalidPlanet = new Planet("", "", "");

       assertThatThrownBy(()-> planetRepository.save(emptyPlanet)).isInstanceOf(RuntimeException.class);
       assertThatThrownBy(()-> planetRepository.save(invalidPlanet)).isInstanceOf(RuntimeException.class);
    }
}