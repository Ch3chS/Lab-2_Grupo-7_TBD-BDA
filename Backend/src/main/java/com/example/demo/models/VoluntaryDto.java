package com.example.demo.models;

import lombok.Data;

/**
 * Este modelo corresponde al DTO de la tabla voluntary
 * voluntary corresponde al voluntario registrado en la plataforma
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 2.0
 */
@Data
public class VoluntaryDto {

    private String rut;
    private String name;
    private String lastnames;
    private String email;
    private String password;
    private String phone;
    private Boolean avaible;
    private String location;

    // Getters y setters

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getAvaible() {
        return avaible;
    }

    public void setAvaible(Boolean avaible) {
        this.avaible = avaible;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
