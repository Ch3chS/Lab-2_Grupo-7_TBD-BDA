package com.example.demo.controllers;

import com.example.demo.models.DateRange;
import com.example.demo.models.Emergency;
import com.example.demo.services.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo Emergency
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/emergencies")
public class EmergencyController {

    @Autowired
    private EmergencyService service;

    /**
     * Crea una nueva emergencia.
     * @param emergency La emergencia a crear.
     * @return La emergencia creada.
     */
    @PostMapping
    public Emergency createEmergency(@RequestBody Emergency emergency) {
        return service.create(emergency);
    }

    /**
     * Obtiene todas las emergencias.
     * @return Una lista de todas las emergencias.
     */
    @GetMapping
    public List<Emergency> getAllEmergencies() {
        return service.getAll();
    }

    

    /**
     * Obtiene una emergencia por su ID.
     * @param id El ID de la emergencia a obtener.
     * @return La emergencia con el ID especificado.
     */
    @GetMapping("/{id}")
    public Emergency getEmergencyById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza una emergencia existente.
     * @param id El ID de la emergencia a actualizar.
     * @param emergency La emergencia actualizada.
     * @return La emergencia actualizada.
     */
    @PutMapping("/{id}")
    public Emergency updateEmergency(@PathVariable Long id, @RequestBody Emergency emergency) {
        return service.update(id, emergency);
    }

    /**
     * Elimina una emergencia por su ID.
     * @param id El ID de la emergencia a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteEmergency(@PathVariable Long id) {
        service.delete(id);
    }

    // ------------------------------------ Métodos extra -------------------------------------------------

    @PostMapping("/byDate")
    public List<Emergency> getEmergenciesByDate(@RequestBody DateRange dateRange) throws Exception {
        return service.getByDate(dateRange.getStartDate(), dateRange.getEndDate());
    }




}
