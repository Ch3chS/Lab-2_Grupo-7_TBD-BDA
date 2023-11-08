package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

/**
 * Este modelo corresponde al de la tabla de query_log
 * query_log corresponde a la tabla que almacena las consultas que se realizan en la plataforma
 * Se almacena el nombre del usuario que realizó la consulta, el texto de la consulta,
 * la tabla a la que se le realizó la consulta y la fecha en la que se realizó la consulta
 * No se puede modificar la tabla
 * No se puede eliminar la tabla
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "query_log")
public class QueryLog {
	// ----------------------------------------- Atributos --------------------------------------------------

	/**
	 * Columna con la id de la consulta, la cual se genera automáticamente de forma creciente.
	 * Es única para cada consulta
	 * No puede ser nula
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id_query;

	/**
	 * Columna con el nombre del usuario que generó la consulta.
	 * No puede ser nulo
	 */
	@Column(nullable = false, length = 50)
	private String username;

	/**
	 * Columna con el nombre de la query que se ejecutó.
	 * No puede ser nulo
	 */
	@Column(nullable = false)
	private String query_text;

	/**
	 * Columna con el nombre de la tabla a la que se le ejecutó la query.
	 * No puede ser nulo
	 */
	@Column(nullable = false, length = 50)
	private String table_name;

	/**
	 * Columna con la fecha en la que se ejecutó la query.
	 * No puede ser nulo
	 */
	@Column(nullable = false)
	private LocalDate date;

	// ----------------------------------------- Métodos -----------------------------------------------------

	/**
	 * Método que permite obtener la id de una consulta
	 * @return id de la consulta (un valor de tipo Long)
	 */
	public Long getId_query() {
		return id_query;
	}

	/**
	 * Método que permite obtener el nombre del usuario que generó la consulta
	 * @return nombre del usuario (un valor de tipo String)
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Método que permite obtener el texto de la query que se ejecutó
	 * @return texto de la query (un valor de tipo String)
	 */
	public String getQuery_text() {
		return query_text;
	}

	/**
	 * Método que permite obtener el nombre de la tabla a la que se le ejecutó la query
	 * @return nombre de la tabla (un valor de tipo String)
	 */
	public String getTable_name() {
		return table_name;
	}

	/**
	 * Método que permite obtener la fecha en la que se ejecutó la query
	 * @return fecha de la query (un valor de tipo LocalDate)
	 */
	public LocalDate getDate() {
		return date;
	}
}
