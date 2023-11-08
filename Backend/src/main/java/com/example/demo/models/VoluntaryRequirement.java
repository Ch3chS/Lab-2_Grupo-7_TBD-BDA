package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde a la tabla intermedia entre los modelos Voluntary y Requirement
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "voluntaryRequirement")
public class VoluntaryRequirement {
   
    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id de la tabla intermedia, la cual se genera automáticamente de forma creciente.
     * Es única para cada una
     * No puede ser nula
     * (Realmente se hizo porque la entidad exige una etiqueta @Id)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_voluntaryRequirement;

    /**
     * Columna con el rut del voluntario
     * Es una llave foránea que hace referencia a la columna rut del modelo Voluntary.
     */
    @Column(nullable = false)
    private String rut_voluntary;

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
    public Long getId_voluntaryRequirement() {
        return id_voluntaryRequirement;
    }

    /**
     * Método que permite obtener el rut del voluntario asociado
     * @return rut del voluntario (un valor de tipo String)
     */
    public String getRut_voluntary() {
        return rut_voluntary;
    }

    /**
     * Método que permite obtener la id del requerimiento asociado
     * @return id del requerimiento (un valor de tipo Long)
     */
    public Long getId_Requirement() {
        return id_requirement;
    }

}
