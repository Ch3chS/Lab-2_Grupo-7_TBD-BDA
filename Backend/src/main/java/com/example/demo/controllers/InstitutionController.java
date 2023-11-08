package com.example.demo.controllers;

import com.example.demo.models.Institution;
import com.example.demo.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo Institution
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {

    @Autowired
    private InstitutionService service;

    /**
     * Crea una nueva institución.
     * @param institution La institución a crear.
     * @return La institución creada.
     */
    @PostMapping
    public Institution createInstitution(@RequestBody Institution institution) {
        return service.create(institution);
    }

    /**
     * Obtiene todas las instituciones.
     * @return Una lista de todas las instituciones.
     */
    @GetMapping
    public List<Institution> getAllInstitutions() {
        return service.getAll();
    }

    /**
     * Obtiene una institución por su ID.
     * @param id El ID de la institución a obtener.
     * @return La institución con el ID especificado.
     */
    @GetMapping("/{id}")
    public Institution getInstitutionById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza una institución existente.
     * @param id El ID de la institución a actualizar.
     * @param institution La institución actualizada.
     * @return La institución actualizada.
     */
    @PutMapping("/{id}")
    public Institution updateInstitution(@PathVariable Long id, @RequestBody Institution institution) {
        return service.update(id, institution);
    }

    /**
     * Elimina una institución por su ID.
     * @param id El ID de la institución a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteInstitution(@PathVariable Long id) {
        service.delete(id);
    }
}
