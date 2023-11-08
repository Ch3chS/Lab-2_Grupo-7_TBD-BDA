package com.example.demo.controllers;

import com.example.demo.models.Requirement;
import com.example.demo.services.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo Requirement
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/requirements")
public class RequirementController {

    @Autowired
    private RequirementService service;

    /**
     * Crea un nuevo requerimiento.
     * @param requirement El requerimiento a crear.
     * @return El requerimiento creado.
     */
    @PostMapping
    public Requirement createRequirement(@RequestBody Requirement requirement) {
        return service.create(requirement);
    }

    /**
     * Obtiene todos los requerimientos.
     * @return Una lista de todos los requerimientos.
     */
    @GetMapping
    public List<Requirement> getAllRequirements() {
        return service.getAll();
    }

    /**
     * Obtiene un requerimiento por su ID.
     * @param id El ID del requerimiento a obtener.
     * @return El requerimiento con el ID especificado.
     */
    @GetMapping("/{id}")
    public Requirement getRequirementById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza un requerimiento existente.
     * @param id El ID del requerimiento a actualizar.
     * @param requirement El requerimiento actualizado.
     * @return El requerimiento actualizado.
     */
    @PutMapping("/{id}")
    public Requirement updateRequirement(@PathVariable Long id, @RequestBody Requirement requirement) {
        return service.update(id, requirement);
    }

    /**
     * Elimina un requerimiento por su ID.
     * @param id El ID del requerimiento a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteRequirement(@PathVariable Long id) {
        service.delete(id);
    }
}

