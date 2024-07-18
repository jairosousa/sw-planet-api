package com.jnsdev.swplanetapi.web.controller;

import com.jnsdev.swplanetapi.domain.Planet;
import com.jnsdev.swplanetapi.domain.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 13/06/2024 - 09:28
 */

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet) {
        var planetCreated = planetService.create(planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> get(@PathVariable("id") Long id) {
        return planetService.get(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Planet> getByName(@PathVariable("name") String name) {
        return planetService.getByName(name).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Planet>> list(@RequestParam(required = false) String climate,
                                             @RequestParam(required = false) String terrain) {
        List<Planet> planets = planetService.list(climate, terrain);
        return ResponseEntity.ok(planets);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable("id") Long id) {
         planetService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
