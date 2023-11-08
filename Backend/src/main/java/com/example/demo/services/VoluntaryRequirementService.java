package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.VoluntaryRequirement;
import com.example.demo.repositories.VoluntaryRequirementRepo;

/**
 * Lógica detras del modelo VoluntaryRequirement, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class VoluntaryRequirementService {
    
    @Autowired
    private VoluntaryRequirementRepo repo;

    /**
     * Creación de un voluntaryRequirement
     * Corresponde al Create del CRUD
     * @param voluntaryRequirement entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public VoluntaryRequirement create(VoluntaryRequirement voluntaryRequirement) {
        return repo.save(voluntaryRequirement);
    }

    /**
     * Obtener todas los voluntaryRequirements
     * @return todas las entidades de la tabla
     */
    public List<VoluntaryRequirement> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener voluntaryRequirement por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public VoluntaryRequirement getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Siendo netamente una tabla intermedia no posee update como tal
     */

    /**
     * Eliminar voluntaryRequirement por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        VoluntaryRequirement voluntaryRequirement = repo.findById(id).orElse(null);
        if (voluntaryRequirement != null) {
            repo.delete(voluntaryRequirement);
        }
    }



    // ---------------------------------- Métodos para eliminación de cascada ----------------------------------

    /**
     * Eliminar por id_requirement
     * @param id_requirement id del requerimiento
     */
    public void deleteByIdRequirement(Long id_requirement) {
        List<VoluntaryRequirement> voluntaryRequirements = repo.findByIdRequirement(id_requirement);
        if (voluntaryRequirements != null) {
            repo.deleteAll(voluntaryRequirements);
        }
    }

    /**
     * Eliminar por rut_voluntary
     * @param rut_voluntary rut del voluntario
     */
    public void deleteByRutVoluntary(String rut_voluntary) {
        List<VoluntaryRequirement> voluntaryRequirement = repo.findByRutVoluntary(rut_voluntary);
        if (voluntaryRequirement != null) {
            repo.deleteAll(voluntaryRequirement);
        }
    }

}
