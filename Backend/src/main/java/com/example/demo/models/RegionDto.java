package com.example.demo.models;

import lombok.Data;

/**
 * Este modelo corresponde al DTO de la tabla region
 * region corresponde a la una region de Chile
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 2.0
 */
@Data
public class RegionDto {

    /**
     * Campo con la id de la región.
     */
    private Long idRegion;

    /**
     * Campo con el nombre de la región.
     */
    private String name;

    /**
     * Campo con la geometría de la región.
     * Es de tipo String en lugar de MultiPolygon.
     */
    private String geom;

    // Getters y setters

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
