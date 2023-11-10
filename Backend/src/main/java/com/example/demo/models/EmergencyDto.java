package com.example.demo.models;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * Este modelo corresponde al DTO de la tabla emergency
 * emergency corresponde a una emergencia registrada en la plataforma
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 2.0
 */
@Data
public class EmergencyDto {

    private long id_emergency;
    private String description;
    private LocalDateTime date;
    private boolean active;
    private Long id_institution;
    private String location;

    // Getters y setters

    public long getId_emergency() {
        return id_emergency;
    }

    public void setId_emergency(long id_emergency) {
        this.id_emergency = id_emergency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId_institution() {
        return id_institution;
    }

    public void setId_institution(Long id_institution) {
        this.id_institution = id_institution;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
