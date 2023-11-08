package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde al de un requerimiento para una tarea
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "requirement")
public class Requirement {

    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id del requerimiento, la cual se genera automáticamente de forma creciente.
     * Es única para cada requerimiento
     * No puede ser nula
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_requirement;
    
    /**
     * Columna con el nombre del requisito.
     * No puede ser nulo
     */
    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Columna con la descripción detallada del requisito.
     * No puede ser nula
     */
    @Column(nullable = false)
    private String description;


    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener la id de un requerimiento
     * @return id del requerimiento (un valor de tipo Long)
     */
    public Long getId_requirement() {
        return id_requirement;
    }

    /**
     * Método que permite obtener el nombre del requerimiento
     * @return nombre del requerimiento (un valor de tipo String)
     */
    public String getName() {
        return name;
    }

    /**
     * Método que permite actualizar el nombre del requerimiento
     * @param name nuevo nombre para el requerimiento (de tipo String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que permite obtener la descripción de un requerimiento
     * @return descripción del requerimiento (un valor de tipo String)
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método que permite actualizar la descripción de un requerimiento
     * @param description nueva descripción para el requerimiento (de tipo String)
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
