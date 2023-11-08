package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Este modelo corresponde al del ranking de un voluntario para una tarea
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "ranking")
public class Ranking {
    
    // ----------------------------------------- Atributos --------------------------------------------------

    /**
     * Columna con la id del ranking, la cual se genera automáticamente de forma creciente.
     * Es única para cada ranking
     * No puede ser nula
     * (Realmente se hizo porque la entidad exije una etiqueta @Id)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_ranking;

    /**
     * Columna con el puntaje del voluntario para una tarea.
     * No puede ser nulo.
     */
    @Column(nullable = false)
    int score;

    /**
     * Columna con el rut del voluntario que tiene el puntaje.
     * Es una llave foránea que hace referencia a la columna rut del modelo Voluntary.
     */
    @Column(nullable = false)
    private String rut_voluntary;

    /**
     * Columna con la id de la tarea asociada.
     * Es una llave foránea que hace referencia a la columna id_task del modelo Task.
     */
    @Column(nullable = false)
    private Long id_task;


    // ----------------------------------------- Métodos -----------------------------------------------------

    /**
     * Método que permite obtener la id del ranking
     * @return id del ranking (un valor de tipo Long)
     */
    public Long getId_ranking() {
        return id_ranking;
    }

    /**
     * Método que permite obtener el puntaje del usuario para la tarea
     * @return puntaje del usuario (un valor de tipo int)
     */
    public int getScore() {
        return score;
    }

    /**
     * Método que permite actualizar el puntaje del usuario para la tarea
     * @param score nueva id para la emergencia (de tipo Long)
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Método que permite obtener el rut del voluntario asociado
     * @return rut del usuario (un valor de tipo String)
     */
    public String getRut_voluntary() {
        return rut_voluntary;
    }

    /**
     * Método que permite obtener la id de la tarea asociada
     * @return id de la tarea (un valor de tipo Long)
     */
    public Long getId_task() {
        return id_task;
    }

}
