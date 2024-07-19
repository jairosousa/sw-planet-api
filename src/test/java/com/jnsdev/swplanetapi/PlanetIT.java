package com.jnsdev.swplanetapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * @Autor Jairo Nascimento
 * @Created 19/07/2024 - 09:37
 */
@ActiveProfiles("it")
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PlanetIT {

    @Test
    void contextLoads() {

    }
}
