package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Requirement;
import com.example.demo.repositories.RequirementRepo;

/**
 * Lógica detras del modelo Requirement, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class RequirementService {
    
    @Autowired
    private RequirementRepo repo;

    @Autowired
    private VoluntaryRequirementService voluntaryRequirementService;

    @Autowired
    private EmergencyRequirementService emergencyRequirementService;

    @Autowired
    private TaskRequirementService taskRequirementService;

    /**
     * Creación de un requisito
     * Corresponde al Create del CRUD
     * @param emergency entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Requirement create(Requirement requirement) {
        return repo.save(requirement);
    }

    /**
     * Obtener todos los requisitos
     * @return todas las entidades de la tabla
     */
    public List<Requirement> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener requisito por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Requirement getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar requisito por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Requirement update(Long id, Requirement requirementDetails) {
        Requirement requirement = repo.findById(id).orElse(null);
        if (requirement != null) {
            requirement.setName(requirementDetails.getName());
            requirement.setDescription(requirementDetails.getDescription());
            return repo.save(requirement);
        }
        return null;
    }

    /**
     * Eliminar requisito por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Requirement requirement = repo.findById(id).orElse(null);
        if (requirement != null) {
            // Eliminar todas las entidades relacionadas en la clase VoluntaryRequirement
            voluntaryRequirementService.deleteByIdRequirement(id);

            // Eliminar todas las entidades relacionadas en la clase EmergencyRequirement
            emergencyRequirementService.deleteByIdRequirement(id);

            // Eliminar todas las entidades relacionadas en la clase TaskRequirement
            taskRequirementService.deleteByIdRequirement(id);

            // Finalmente, eliminar el requerimiento
            repo.delete(requirement);
        }
    }

}
