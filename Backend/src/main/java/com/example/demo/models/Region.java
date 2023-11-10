package com.example.demo.models;

import org.locationtech.jts.geom.MultiPolygon;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde al de la tabla region
 * region corresponde a la una region de Chile
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 2.0
 */
@Data
@Entity
@Table(name = "region")
public class Region {

    /**
     * Columna con la id de la región, la cual se genera automáticamente de forma creciente.
     * Es única para cada región
     * No puede ser nula
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_region", unique = true, nullable = false)
    private Long idRegion;

    /**
     * Columna con el nombre de la región.
     * No puede ser nula
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Columna con la geometría de la región.
     * Es de tipo GEOMETRY en la base de datos.
     */
    @Column(name = "geom", nullable = false)
    private MultiPolygon geom;

    // Getters y setters

    /**
     * Método que permite obtener la id de una región
     * @return id de la región (un valor de tipo Long)
     */
    public Long getIdRegion() {
        return idRegion;
    }

    /**
     * Método que permite obtener el nombre de una región
     * @return nombre de la región (un valor de tipo String)
     */
    public String getName() {
        return name;
    }

    /**
     * Método que permite actualizar el nombre de una región
     * @param name nuevo nombre para la región (de tipo String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que permite obtener la geometría de una región
     * @return geometría de la región (un valor de tipo string)
     */
    public MultiPolygon getGeom() {
        return geom;
    }

    /**
     * Método que permite actualizar la geometría de una región
     * @param geom nueva geometría para la región (de tipo string)
     */
    public void setGeom(MultiPolygon geom) {
        this.geom = geom;
    }
}
