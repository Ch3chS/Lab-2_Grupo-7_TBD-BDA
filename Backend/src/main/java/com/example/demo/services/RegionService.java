package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.models.Region;
import com.example.demo.repositories.RegionRepo;

/**
 * Lógica detras del modelo Region, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 */
@Service
public class RegionService {
    
    @Autowired
    private RegionRepo repo;

    /**
     * Creación de una región
     * Corresponde al Create del CRUD
     * @param region entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Region create(Region region) {
        return repo.save(region);
    }

    /**
     * Obtener todas las regiones
     * @return todas las entidades de la tabla
     */
    public List<Region> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener región por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Region getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar una región
     * Corresponde al Update del CRUD
     * @param region entidad a actualizar en la base de datos
     * @return entidad actualizada
     */
    public Region update(Region region) {
        return repo.save(region);
    }

    /**
     * Eliminar región por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Region region = repo.findById(id).orElse(null);
        if (region != null) {
            repo.delete(region);
        }
    }
}
