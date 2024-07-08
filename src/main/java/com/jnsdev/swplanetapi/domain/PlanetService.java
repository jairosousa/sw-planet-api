package com.jnsdev.swplanetapi.domain;

import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Planet> get(Long id) {
        return planetRepository.findById(id);
    }

    public Optional<Planet> getByName(String name) {
        return planetRepository.findByName(name);
    }
}

