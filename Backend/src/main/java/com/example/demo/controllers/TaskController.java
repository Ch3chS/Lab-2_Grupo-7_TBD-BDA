package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo Task
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    /**
     * Crea una nueva tarea.
     * @param task La tarea a crear.
     * @return La tarea creada.
     */
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.create(task);
    }

    /**
     * Obtiene todas las tareas.
     * @return Una lista de todas las tareas.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    /**
     * Obtiene una tarea por su ID.
     * @param id El ID de la tarea a obtener.
     * @return La tarea con el ID especificado.
     */
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Actualiza una tarea existente.
     * @param id El ID de la tarea a actualizar.
     * @param task La tarea actualizada.
     * @return La tarea actualizada.
     */
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return service.update(id, task);
    }

    /**
     * Elimina una tarea por su ID.
     * @param id El ID de la tarea a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/byEmergency/{id_emergency}")
    public List<Task> getTaskByEmergencyId(@PathVariable Long id_emergency) {
        return service.findByIdEmergency(id_emergency);
    }

}
