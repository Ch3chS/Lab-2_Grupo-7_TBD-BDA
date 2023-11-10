package com.example.demo.models;


import org.locationtech.jts.geom.Point;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde al de la tabla de voluntary
 * voluntary corresponde al voluntario registrado en la plataforma
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 2.0
 */
@Data
@Entity
@Table(name = "voluntary")
public class Voluntary {

    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con el rut del voluntario, el cual cuenta de 12 caracteres XXXXXXXX-X.
     * Es único por lo que será la llave primaria
     * No puede ser nulo
     */
    @Id
    @Column(unique = true, nullable = false, length = 10)
    private String rut;
    /**
     * Columna con el nombre del voluntario.
     * Se espera un largo de máximo 30.
     * No puede ser nulo.
     */
    @Column(nullable = false, length = 30)
    private String name;

    /**
     * Columna con los apellidos del voluntario.
     * Se espera un largo de máximo 60.
     * No puede ser nulo.
     */
    @Column(nullable = false, length = 60)
    private String lastnames;

    /**
     * Columna con la dirección de correo electrónico del voluntario.
     * Se espera un largo de máximo 255 segun las normas establecidas.
     * Se espera que sea única.
     * No puede ser nula.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /**
     * Columna con la contraseña del voluntario.
     * Se espera un largo de máximo 255 caracteres.
     * No puede ser nula.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Columna con el telefono del voluntario.
     * Se espera un largo de máximo 12 contando el código de país, etc.
     * No puede ser nulo.
     */
    @Column(nullable = false, length = 12)
    private String phone;

    /**
     * Columna con la disponibilidad del usuario del voluntario.
     * 1 o true será disponible, 0 o false será no disponible.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    private Boolean avaible;

    /**
     * Columna con la ubicación del voluntario. 
     * Actualización postGIS (lab 2)
     */
    @Column(name = "location", nullable = false, columnDefinition = "GEOMETRY(Point, 4236)")
    private Point location;

    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener el rut de un voluntario
     * @return rut del voluntario (un valor de tipo String)
     */
    public String getRut() {
        return rut;
    }

    /**
     * Método que permite obtener el nombre de un voluntario
     * @return nombre del voluntario (un valor de tipo String)
     */
    public String getName() {
        return name;
    }

    /**
     * Método que permite actualizar el nombre de un voluntario
     * @param name nuevo nombre del usuario (de tipo String)
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Método que permite obtener los apellidos de un voluntario
     * @return apellidos del voluntario (un valor de tipo String)
     */
    public String getLastnames() {
        return lastnames;
    }

    /**
     * Método que permite actualizar los apellidos de un voluntario
     * @param lastnames apellidos del usuario (de tipo String)
     */
    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    /**
     * Método que permite obtener la dirección de correo electrónico de un voluntario
     * @return dirección de correo electrónico del voluntario (un valor de tipo String)
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que permite actualizar la dirección de correo electrónico de un voluntario
     * @param email dirección de correo electrónico del usuario (de tipo String)
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que permite obtener el número de telefono de un voluntario
     * @return número de telefono del voluntario (un valor de tipo String)
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Método que permite actualizar el número de telefono de un voluntario
     * @param phone número de telefono del usuario (de tipo String)
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Método que permite obtener la disponibilidad de un voluntario
     * @return disponibilidad del voluntario (un valor de tipo booleano (disponible: 1, no disponible: 0))
     */
    public Boolean getAvaible() {
        return avaible;
    }

    /**
     * Método que permite actualizar la disponibilidad de un voluntario
     * @param avaible disponibilidad del usuario (un valor de tipo booleano (disponible: 1, no disponible: 0))
     */
    public void setAvaible(Boolean avaible) {
        this.avaible = avaible;
    }

    /**
     * Método que permite obtener la ubicación de un voluntario
     * @return ubicación del voluntario (un valor de tipo Geometry)
     */
    public Point getLocation() {
        return location;
    }

    /**
     * Método que permite actualizar la ubicación de un voluntario
     * @param location nueva ubicación para el voluntario (de tipo Geometry)
     */
    public void setLocation(Point location) {
        this.location = location;
    }

}
