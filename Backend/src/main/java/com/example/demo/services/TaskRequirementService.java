package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TaskRequirement;
import com.example.demo.repositories.TaskRequirementRepo;

/**
 * Lógica detras del modelo TaskRequirement, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class TaskRequirementService {
    
    @Autowired
    private TaskRequirementRepo repo;

    /**
     * Creación de un taskRequirement
     * Corresponde al Create del CRUD
     * @param taskRequirement entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public TaskRequirement create(TaskRequirement taskRequirement) {
        return repo.save(taskRequirement);
    }

    /**
     * Obtener todas los taskRequirements
     * @return todas las entidades de la tabla
     */
    public List<TaskRequirement> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener taskRequirement por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public TaskRequirement getById(Long id) {
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
        TaskRequirement taskRequirement = repo.findById(id).orElse(null);
        if (taskRequirement != null) {
            repo.delete(taskRequirement);
        }
    }



// ---------------------------------- Métodos para eliminación de cascada ----------------------------------

/**
 * Eliminar por id_task
 * @param id_task id de la tarea
 */
public void deleteByIdTask(Long id_task) {
    List<TaskRequirement> taskRequirements = repo.findByIdTask(id_task);
    if (taskRequirements != null) {
        repo.deleteAll(taskRequirements);
    }
}

/**
 * Eliminar por id_requirement
 * @param id_requirement id del requerimiento
 */
public void deleteByIdRequirement(Long id_requirement) {
    List<TaskRequirement> taskRequirements = repo.findByIdRequirement(id_requirement);
    if (taskRequirements != null) {
        repo.deleteAll(taskRequirements);
    }
}


}
