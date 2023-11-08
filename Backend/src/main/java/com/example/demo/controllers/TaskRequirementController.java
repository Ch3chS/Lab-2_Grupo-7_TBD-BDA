package com.example.demo.controllers;

import com.example.demo.models.TaskRequirement;
import com.example.demo.services.TaskRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que mapea los servicios referentes al modelo TaskRequirement
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@RestController
@RequestMapping("/api/taskRequirements")
public class TaskRequirementController {

    @Autowired
    private TaskRequirementService service;

    /**
     * Crea un nuevo requerimiento de tarea.
     * @param taskRequirement El requerimiento de tarea a crear.
     * @return El requerimiento de tarea creado.
     */
    @PostMapping
    public TaskRequirement createTaskRequirement(@RequestBody TaskRequirement taskRequirement) {
        return service.create(taskRequirement);
    }

    /**
     * Obtiene todos los requerimientos de tareas.
     * @return Una lista de todos los requerimientos de tareas.
     */
    @GetMapping
    public List<TaskRequirement> getAllTaskRequirements() {
        return service.getAll();
    }

    /**
     * Obtiene un requerimiento de tarea por su ID.
     * @param id El ID del requerimiento de tarea a obtener.
     * @return El requerimiento de tarea con el ID especificado.
     */
    @GetMapping("/{id}")
    public TaskRequirement getTaskRequirementById(@PathVariable Long id) {
        return service.getById(id);
    }

    /**
     * Elimina un requerimiento de tarea por su ID.
     * @param id El ID del requerimiento de tarea a eliminar.
     */
    @DeleteMapping("/{id}")
    public void deleteTaskRequirement(@PathVariable Long id) {
        service.delete(id);
    }
}
