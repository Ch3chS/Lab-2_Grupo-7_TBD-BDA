package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde a la tabla intermedia entre los modelos Task y Requirement
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "taskRequirement")
public class TaskRequirement {
    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id de la tabla intermedia, la cual se genera automáticamente de forma creciente.
     * Es única para cada una
     * No puede ser nula
     * (Realmente se hizo porque la entidad exije una etiqueta @Id)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_taskRequirement;

    /**
     * Columna con la id de la tarea asociada
     * Es una llave foránea que hace referencia a la columna id_task del modelo Task.
     */
    @Column(nullable = false)
    private Long id_task;

    /**
     * Columna con la id del requisito asociado.
     * Es una llave foránea que hace referencia a la columna id_requirement del modelo Requirement.
     */
    @Column(nullable = false)
    private Long id_requirement;


    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener la id de la tabla intermedia
     * @return id de la tabla intermedia (un valor de tipo Long)
     */
    public Long getId_taskRequirement() {
        return id_taskRequirement;
    }

    /**
     * Método que permite obtener la id de la tarea asociada
     * @return id de la tarea (un valor de tipo Long)
     */
    public Long getId_task() {
        return id_task;
    }

    /**
     * Método que permite obtener la id del requerimiento asociado
     * @return id del requerimiento (un valor de tipo Long)
     */
    public Long getId_Requirement() {
        return id_requirement;
    }

}
