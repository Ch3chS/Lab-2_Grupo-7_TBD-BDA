package com.example.demo.controllers;

import com.example.demo.models.Region;
import com.example.demo.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo Region
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 2.0
 */
@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService service;

    /**
     * Crea una nueva región.
     * @param region La región a crear.
     * @return La región creada.
     */
    @PostMapping
    public Region createRegion(@RequestBody Region region) {
        return service.create(region);
    }

    /**
     * Obtiene todas las regiones.
     * @return Una lista de todas las regiones.
     */
    @GetMapping
    public List<Region> getAllRegions() {
        return service.getAll();
    }

    /**
     * Obtiene una región por su ID.
     * @param id El ID de la región a obtener.
     * @return La región con el ID especificado.
     */
    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza una región.
     * @param region La región a actualizar.
     * @return La región actualizada.
     */
    @PutMapping
    public Region updateRegion(@RequestBody Region region) {
        return service.update(region);
    }

    /**
     * Elimina una región por su ID.
     * @param id El ID de la región a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id) {
        service.delete(id);
    }
}
