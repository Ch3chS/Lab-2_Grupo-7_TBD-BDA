package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.models.TaskStatus;
import com.example.demo.services.TaskStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo TaskStatus
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/taskStatuses")
public class TaskStatusController {

    @Autowired
    private TaskStatusService service;

    /**
     * Crea un nuevo estado de tarea.
     * @param taskStatus El estado de tarea a crear.
     * @return El estado de tarea creado.
     */
    @PostMapping
    public TaskStatus createTaskStatus(@RequestBody TaskStatus taskStatus) {
        return service.create(taskStatus);
    }

    /**
     * Obtiene todos los estados de tareas.
     * @return Una lista de todos los estados de tareas.
     */
    @GetMapping
    public List<TaskStatus> getAllTaskStatuses() {
        return service.getAll();
    }

    /**
     * Obtiene un estado de tarea por su ID.
     * @param id El ID del estado de tarea a obtener.
     * @return El estado de tarea con el ID especificado.
     */
    @GetMapping("/{id}")
    public TaskStatus getTaskStatusById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza un estado de tarea existente.
     * @param id El ID del estado de tarea a actualizar.
     * @param taskStatus El estado de tarea actualizado.
     * @return El estado de tarea actualizado.
     */
    @PutMapping("/{id}")
    public TaskStatus updateTaskStatus(@PathVariable Long id, @RequestBody TaskStatus taskStatus) {
        return service.update(id, taskStatus);
    }

    /**
     * Elimina un estado de tarea por su ID.
     * @param id El ID del estado de tarea a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteTaskStatus(@PathVariable Long id) {
        service.delete(id);
    }


    /**
     * Obtiene todas las tareas disponibles para un voluntario.
     * @param voluntaryRut El rut del voluntario.
     * Se obtiene desde el token de autenticación.
     */
    @GetMapping("/availableTasksForVoluntary/{voluntaryRut}")
    public List<Task> getAvailableTasksForVoluntary(@PathVariable String voluntaryRut) {
        return service.findAvailableTaskStatusForVoluntary(voluntaryRut);
    }
}
