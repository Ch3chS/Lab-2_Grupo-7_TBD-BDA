package com.example.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde al de una emergencia
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 2.0
 */
@Data
@Entity
@Table(name = "emergency")
public class Emergency {
    
    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id de la emergencia, la cual se genera automáticamente de forma creciente.
     * Es única para cada emergencia
     * No puede ser nula
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_emergency;

    /**
     * Columna con la descripción detallada de la emergencia.
     * No puede ser nula
     */
    @Column(nullable = false)
    private String description;

    /**
     * Columna con la fecha y hora de la emergencia, la cual se genera automáticamente con la hora de creación de la misma.
     * No puede ser nula
     */
    @Column(nullable = false)
    private LocalDateTime date;

    /**
     * Columna que dice si la emergencia sigue activa, 1 para activa 0 para inactiva.
     * No puede ser nula
     */
    @Column(nullable = false)
    private boolean active;

    /**
     * Columna con la id de la institución a la que pertenece la emergencia.
     * Es una llave foránea que hace referencia a la columna id_institution del modelo Institution.
     */
    @Column(nullable = false)
    private Long id_institution;

    /**
     * Columna con la ubicación de la emergencia.
     * Actualización postGIS (lab 2)
     */
    @Column(nullable = false)
    private String location;


    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener la id de una emergencia
     * @return id de la emergencia (un valor de tipo Long)
     */
    public Long getId_emergency() {
        return id_emergency;
    }

    /**
     * Método que permite obtener la descripción de una emergencia
     * @return descripción de la emergencia (un valor de tipo String)
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método que permite actualizar la descripción de una emergencia
     * @param description nueva descripción para la emergencia (de tipo String)
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método que permite obtener la fecha y hora de una emergencia
     * @return fecha y hora de la emergencia (un valor de tipo Timestamp)
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Método que permite actualizar la fecha y hora de una emergencia
     * @param date nueva fecha y hora para la emergencia (de tipo Timestamp)
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Método que permite obtener si una emergencia esta activa o no.
     * @return actividad de la emergencia (un valor de tipo boolean)
     */
    public boolean getActive() {
        return active;
    }

    /**
     * Método que permite actualizar la actividad de una emergencia
     * @param active nuevo valor (de tipo boolean)
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Método que permite obtener la id de la institución a la que pertenece la emergencia
     * @return id de la institución (un valor de tipo Long)
     */
    public Long getId_institution() {
        return id_institution;
    }

    /**
     * Método que permite obtener la ubicación de una emergencia
     * @return ubicación de la emergencia (un valor de tipo Geometry)
     */
    public String getLocation() {
        return location;
    }

    /**
     * Método que permite actualizar la ubicación de una emergencia
     * @param location nueva ubicación para la emergencia (de tipo Geometry)
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
}
