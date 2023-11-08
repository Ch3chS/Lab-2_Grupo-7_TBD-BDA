package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde al de la tabla de institution
 * institution corresponde a la institución encargada de los esfuerzos en diferentes emergencias
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "institution")
public class Institution {
    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id de la institución, la cual se genera automáticamente de forma creciente.
     * Es única para cada institución
     * No puede ser nula
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_institution;

    /**
     * Columna con el nombre de la institución.
     * Es único para cada institución
     * No puede ser nulo
     */
    @Column(unique = true, nullable = false, length = 60)
    private String name;


    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener la id de una institución
     * @return id de la institución (un valor de tipo Long)
     */
    public Long getId_institution() {
        return id_institution;
    }

    /**
     * Método que permite obtener el nombre de una institución
     * @return nombre de la institución (un valor de tipo String)
     */
    public String getName() {
        return name;
    }

    /**
     * Método que permite actualizar el nombre de una institución
     * @param name nuevo nombre para la institución (de tipo String)
     */
    public void setName(String name) {
        this.name = name;
    }
}
