package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TaskStatus;
import com.example.demo.repositories.TaskStatusRepo;

/**
 * Lógica detras del modelo TaskStatus, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class TaskStatusService {
    @Autowired
    TaskStatusRepo repo;

    @Autowired
    TaskService taskService;

    /**
     * Creación de un taskStatus
     * Corresponde al Create del CRUD
     * @param taskStatus entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public TaskStatus create(TaskStatus taskStatus){
        return repo.save(taskStatus);
    }

    /**
     * Obtener todas los taskStatus
     * @return todas las entidades de la tabla
     */
    public List<TaskStatus> getAll(){
        return repo.findAll();
    }

    /**
     * Obtener taskStatus por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public TaskStatus getById(Long id){
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar taskStatus por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public TaskStatus update(Long id, TaskStatus taskStatusDetails) {
        TaskStatus taskStatus = repo.findById(id).orElse(null);
        if(taskStatus != null) {
            taskStatus.setName(taskStatusDetails.getName());
            return repo.save(taskStatus);
        }
        return null;
    }

    /**
     * Eliminar taskStatus por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        TaskStatus taskStatus = repo.findById(id).orElse(null);
        if(taskStatus != null){

            // Eliminar todas las entidades relacionadas en la clase Ranking
            taskService.deleteByIdTaskStatus(id);

            // Finalmente, eliminar el taskStatus
            repo.delete(taskStatus);
        }
    }


    // ---------------------------------- Métodos para encontrar por nombre ----------------------------------
    /**
     * Obtener taskStatus por nombre
     * @param name nombre de la entidad
     * @return entidad con el nombre respectivo (o null en caso de no encontrarse)
     */
    public TaskStatus getByName(String name) {
        return repo.findByName(name);
    }

    // ---------------------------------- Encontrar tareas para un voluntario ----------------------------------
    /**
     * Obtener taskStatus por nombre
     *
     * @param voluntaryRut nombre de la entidad
     * @return entidad con el nombre respectivo (o null en caso de no encontrarse)
     */
    public List<Task> findAvailableTaskStatusForVoluntary(String voluntaryRut) {
        TaskStatus pendingStatus = repo.findByName("Pendiente");
        List<Task> tasks = repo.findAvailableTasksForVoluntary(voluntaryRut, pendingStatus.getId_taskStatus());
        System.out.println("Number of tasks found: " + tasks.size());
        return tasks;

    }
}
