package com.example.demo.controllers;

import com.example.demo.models.Ranking;
import com.example.demo.models.Voluntary;
import com.example.demo.services.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo Ranking
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/rankings")
public class RankingController {

    @Autowired
    private RankingService service;

    /**
     * Crea un nuevo ranking.
     * @param ranking El ranking a crear.
     * @return El ranking creado.
     */
    @PostMapping
    public Ranking createRanking(@RequestBody Ranking ranking) {
        return service.create(ranking);
    }

    /**
     * Obtiene todos los rankings.
     * @return Una lista de todos los rankings.
     */
    @GetMapping
    public List<Ranking> getAllRankings() {
        return service.getAll();
    }

    /**
     * Obtiene un ranking por su ID.
     * @param id El ID del ranking a obtener.
     * @return El ranking con el ID especificado.
     */
    @GetMapping("/{id}")
    public Ranking getRankingById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza un ranking existente.
     * @param id El ID del ranking a actualizar.
     * @param ranking El ranking actualizado.
     * @return El ranking actualizado.
     */
    @PutMapping("/{id}")
    public Ranking updateRanking(@PathVariable Long id, @RequestBody Ranking ranking) {
        return service.update(id, ranking);
    }

    /**
     * Elimina un ranking por su ID.
     * @param id El ID del ranking a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteRanking(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/minRanking/voluntary/{id}")
    public Voluntary getMinRankingVoluntary(@PathVariable Long id) {
        return service.getMinRankingVoluntary(id);
    }
}
