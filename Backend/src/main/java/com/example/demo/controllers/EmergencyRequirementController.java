package com.example.demo.controllers;

import com.example.demo.models.EmergencyRequirement;
import com.example.demo.services.EmergencyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo EmergencyRequirement
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/emergencyRequirements")
public class EmergencyRequirementController {

    @Autowired
    private EmergencyRequirementService service;

    /**
     * Crea un nuevo requerimiento de emergencia.
     * @param emergencyRequirement El requerimiento de emergencia a crear.
     * @return El requerimiento de emergencia creado.
     */
    @PostMapping
    public EmergencyRequirement createEmergencyRequirement(@RequestBody EmergencyRequirement emergencyRequirement) {
        return service.create(emergencyRequirement);
    }

    /**
     * Obtiene todos los requerimientos de emergencia.
     * @return Una lista de todos los requerimientos de emergencia.
     */
    @GetMapping
    public List<EmergencyRequirement> getAllEmergencyRequirements() {
        return service.getAll();
    }

    /**
     * Obtiene un requerimiento de emergencia por su ID.
     * @param id El ID del requerimiento de emergencia a obtener.
     * @return El requerimiento de emergencia con el ID especificado.
     */
    @GetMapping("/{id}")
    public EmergencyRequirement getEmergencyRequirementById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Elimina un requerimiento de emergencia por su ID.
     * @param id El ID del requerimiento de emergencia a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteEmergencyRequirement(@PathVariable Long id) {
        service.delete(id);
    }
}
