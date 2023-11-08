package com.example.demo.controllers;

import com.example.demo.models.VoluntaryRequirement;
import com.example.demo.services.VoluntaryRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo VoluntaryRequirement
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/voluntaryRequirements")
public class VoluntaryRequirementController {

    @Autowired
    private VoluntaryRequirementService service;

    /**
     * Crea un nuevo requerimiento de voluntario.
     * @param voluntaryRequirement El requerimiento de voluntario a crear.
     * @return El requerimiento de voluntario creado.
     */
    @PostMapping
    public VoluntaryRequirement createVoluntaryRequirement(@RequestBody VoluntaryRequirement voluntaryRequirement) {
        return service.create(voluntaryRequirement);
    }

    /**
     * Obtiene todos los requerimientos de voluntarios.
     * @return Una lista de todos los requerimientos de voluntarios.
     */
    @GetMapping
    public List<VoluntaryRequirement> getAllVoluntaryRequirements() {
        return service.getAll();
    }

    /**
     * Obtiene un requerimiento de voluntario por su ID.
     * @param id El ID del requerimiento de voluntario a obtener.
     * @return El requerimiento de voluntario con el ID especificado.
     */
    @GetMapping("/{id}")
    public VoluntaryRequirement getVoluntaryRequirementById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Elimina un requerimiento de voluntario por su ID.
     * @param id El ID del requerimiento de voluntario a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteVoluntaryRequirement(@PathVariable Long id) {
        service.delete(id);
    }
}
