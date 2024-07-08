package com.jnsdev.swplanetapi.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @Autor Jairo Nascimento
 * @Created 13/06/2024 - 09:32
 */
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    Optional<Planet> findByName(String name);
}
