package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepo;

/**
 * Lógica detras del modelo Task, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;

    @Autowired
    private RankingService rankingService;

    @Autowired
    private TaskRequirementService taskRequirementService;


    /**
     * Creación de una tarea
     * Corresponde al Create del CRUD
     * @param task entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Task create(Task task) {
        return repo.save(task);
    }

    /**
     * Obtener todas las tareas
     * @return todas las entidades de la tabla
     */
    public List<Task> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener tarea por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Task getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar tarea por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Task update(Long id, Task taskDetails) {
        Task task = repo.findById(id).orElse(null);
        if (task != null) {
            task.setName(taskDetails.getName());
            task.setDescription(taskDetails.getDescription());
            return repo.save(task);
        }
        return null;
    }

    /**
     * Eliminar tarea por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Task task = repo.findById(id).orElse(null);
        if (task != null) {

            // Eliminar todas las entidades relacionadas en la clase Ranking
            rankingService.deleteByIdTask(id);

            // Eliminar todas las entidades relacionadas en la clase taskRequirement
            taskRequirementService.deleteByIdTask(id);

            // Finalmente, eliminar la tarea
            repo.delete(task);
        }
    }



    // ---------------------------------- Métodos para eliminación de cascada ----------------------------------

    /**
     * Eliminar por id_taskStatus
     * @param id_taskStatus id del estado de la tarea
     */
    public void deleteByIdTaskStatus(Long id_taskStatus) {
        List<Task> tasks = repo.findByIdTaskStatus(id_taskStatus);
        if (tasks != null) {
            for (Task task : tasks) {
                delete(task.getId_task());
            }
        }
    }

    /**
     * Eliminar por id_emergency
     * @param id_emergency id de la emergencia
     */
    public void deleteByIdEmergency(Long id_emergency) {
        List<Task> tasks = repo.findByIdEmergency(id_emergency);
        if (tasks != null) {
            for (Task task : tasks) {
                delete(task.getId_task());
            }
        }
    }

    // ---------------------------------- Métodos para funcionalidades extra ----------------------------------

    public List<Task> findByIdEmergency(Long id_emergency) {
        return repo.findByIdEmergency(id_emergency);
    }



}
