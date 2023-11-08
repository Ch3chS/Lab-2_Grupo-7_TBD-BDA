package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde al de la tabla de task
 * task corresponde a una tarea a realizar en el voluntariado
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "task")
public class Task {

    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id de la, la cual se genera automáticamente de forma creciente.
     * Es única para cada tarea
     * No puede ser nula
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_task;
    
    /**
     * Columna con el nombre de la tarea.
     * No puede ser nulo
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Columna con la descripción de la tarea.
     */
    @Column()
    private String description;

    /**
     * Columna con la id del estado de la tarea.
     * Es una llave foránea que hace referencia a la columna id_taskStatus del modelo TaskStatus.
     */
    @Column(nullable = false)
    private Long id_taskStatus;

    /**
     * Columna con la id de la emergencia a la que pertenece la tarea.
     * Es una llave foránea que hace referencia a la columna id_emergency del modelo Emergency.
     */
    @Column(nullable = false)
    private Long id_emergency;


    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener la id de la tarea
     * @return id de la tarea (un valor de tipo Long)
     */
    public Long getId_task() {
        return id_task;
    }

    /**
     * Método que permite obtener el nombre de la tarea
     * @return nombre de la tarea (un valor de tipo String)
     */
    public String getName() {
        return name;
    }

    /**
     * Método que permite actualizar el nombre de la tarea
     * @param name nuevo nombre para la tarea (de tipo String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que permite obtener la descripción de la tarea
     * @return descripción de la tarea (un valor de tipo String)
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método que permite actualizar la descripción de la tarea
     * @param description nueva descripción para la tarea (de tipo String)
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método que permite obtener la id del estado de la tarea
     * @return id del estado de la tarea (un valor de tipo Long)
     */
    public Long getId_taskStatus() {
        return id_taskStatus;
    }

    /**
     * Método que permite obtener la id de la emergencia asociada
     * @return id de la emergencia (un valor de tipo Long)
     */
    public Long getId_emergency() {
        return id_emergency;
    }

}
