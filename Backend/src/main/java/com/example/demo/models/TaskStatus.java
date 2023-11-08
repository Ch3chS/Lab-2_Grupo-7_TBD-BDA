package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde al de la tabla de taskStatus
 * un taskStatus corresponde al posible estado de una tarea a realizar en el voluntariado
 * los posibles nombres a tomar son "Pendiente", "En progreso" y "Terminada"
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "taskStatus")
public class TaskStatus {

    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id del taskStatus, la cual se genera automáticamente de forma creciente.
     * Es única para cada taskStatus
     * No puede ser nula
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_taskStatus;

    /**
     * Columna con el nombre del taskStatus.
     * Es único para cada taskStatus
     * No puede ser nulo
     */
    @Column(unique = true, nullable = false, length = 11)
    private String name;


    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener la id de un taskStatus
     * @return id del taskStatus (un valor de tipo Long)
     */
    public Long getId_taskStatus() {
        return id_taskStatus;
    }

    /**
     * Método que permite obtener el nombre de un taskStatus
     * @return nombre del taskStatus (un valor de tipo String)
     */
    public String getName() {
        return name;
    }

    /**
     * Método que permite actualizar el nombre de un taskStatus
     * @param name nuevo nombre para el taskStatus (de tipo String)
     */
    public void setName(String name) {
        this.name = name;
    }
}
