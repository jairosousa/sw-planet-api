package com.jnsdev.swplanetapi.domain;

import org.springframework.stereotype.Service;

/**
 * @Autor Jairo Nascimento
 * @Created 13/06/2024 - 09:31
 */
@Service
public class PlanetService {

    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet) {
        return planetRepository.save(planet);
    }
}

