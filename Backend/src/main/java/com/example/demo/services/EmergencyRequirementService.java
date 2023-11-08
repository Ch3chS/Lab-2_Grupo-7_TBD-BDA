package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.EmergencyRequirement;
import com.example.demo.repositories.EmergencyRequirementRepo;

/**
 * Lógica detras del modelo EmergencyRequirement, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class EmergencyRequirementService {
    
    @Autowired
    private EmergencyRequirementRepo repo;

    /**
     * Creación de un emergencyRequirement
     * Corresponde al Create del CRUD
     * @param emergencyRequirement entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public EmergencyRequirement create(EmergencyRequirement emergencyRequirement) {
        return repo.save(emergencyRequirement);
    }

    /**
     * Obtener todas los emergencyRequirements
     * @return todas las entidades de la tabla
     */
    public List<EmergencyRequirement> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener emergencyRequirement por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public EmergencyRequirement getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Siendo netamente una tabla intermedia no posee update como tal
     */

    /**
     * Eliminar emergencyRequirement por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        EmergencyRequirement emergencyRequirement = repo.findById(id).orElse(null);
        if (emergencyRequirement != null) {
            repo.delete(emergencyRequirement);
        }
    }




    // ---------------------------------- Métodos para eliminación de cascada ----------------------------------

/**
 * Eliminar por id_emergency
 * @param id_emergency id de la emergencia
 */
public void deleteByIdEmergency(Long id_emergency) {
    List<EmergencyRequirement> emergencyRequirements = repo.findByIdEmergency(id_emergency);
    if (emergencyRequirements != null) {
        repo.deleteAll(emergencyRequirements);
    }
}

/**
 * Eliminar por id_requirement
 * @param id_requirement id del requerimiento
 */
public void deleteByIdRequirement(Long id_requirement) {
    List<EmergencyRequirement> emergencyRequirements = repo.findByIdRequirement(id_requirement);
    if (emergencyRequirements != null) {
        repo.deleteAll(emergencyRequirements);
    }
}

    
}
