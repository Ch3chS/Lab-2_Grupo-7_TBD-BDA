package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "query_voluntary_log")
public class QueryVoluntaryLog {

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
	@Column(nullable = false)
	private int id_voluntary;

	/**
	 * Columna con el nombre de la query que se ejecutó.
	 * No puede ser nulo
	 */
	@Column(nullable = false)
	private int id_task;

	/**
	 * Columna con el nombre de la tabla a la que se le ejecutó la query.
	 * No puede ser nulo
	 */
	@Column(nullable = false, length = 50)
	private String action_type;

	/**
	 * Columna con la fecha en la que se ejecutó la query.
	 * No puede ser nulo
	 */
	@Column(nullable = false)
	private LocalDate action_date;

	// ----------------------------------------- Trigger --------------------------------------------------

	/**
	 *
	 * -- Trigger para registrar la acción de aceptar una tarea
	 * CREATE OR REPLACE FUNCTION task_accepted_trigger()
	 *     RETURNS TRIGGER AS $$
	 * BEGIN
	 *     INSERT INTO query_voluntary_log (task_id, volunteer_id, action_type, action_timestamp)
	 *     VALUES (NEW.id_task, NEW.volunteer_id, 'Aceptar', NOW());
	 *     RETURN NEW;
	 * END;
	 * $$ LANGUAGE plpgsql;
	 *
	 * -- Trigger para registrar la acción de rechazar una tarea
	 * CREATE OR REPLACE FUNCTION task_rejected_trigger()
	 *     RETURNS TRIGGER AS $$
	 * BEGIN
	 *     INSERT INTO query_voluntary_log (task_id, volunteer_id, action_type, action_timestamp)
	 *     VALUES (NEW.id_task, NEW.volunteer_id, 'Rechazar', NOW());
	 *     RETURN NEW;
	 * END;
	 * $$ LANGUAGE plpgsql;
	 *
	 * -- Trigger para registrar la acción de cancelar una tarea
	 * CREATE OR REPLACE FUNCTION task_cancelled_trigger()
	 *     RETURNS TRIGGER AS $$
	 * BEGIN
	 *     INSERT INTO query_voluntary_log (task_id, volunteer_id, action_type, action_timestamp)
	 *     VALUES (NEW.id_task, NEW.volunteer_id, 'Cancelar', NOW());
	 *     RETURN NEW;
	 * END;
	 * $$ LANGUAGE plpgsql;
	 *
	 * -- Trigger para registrar la acción de terminar una tarea
	 * CREATE OR REPLACE FUNCTION task_completed_trigger()
	 *     RETURNS TRIGGER AS $$
	 * BEGIN
	 *     INSERT INTO query_voluntary_log (task_id, volunteer_id, action_type, action_timestamp)
	 *     VALUES (NEW.id_task, NEW.volunteer_id, 'Terminar', NOW());
	 *     RETURN NEW;
	 * END;
	 * $$ LANGUAGE plpgsql;
	 *
	 *
	 * -- Asociar el trigger de aceptar a la acción de aceptar en la tabla tasks
	 * CREATE TRIGGER task_accept
	 *     AFTER INSERT
	 *     ON tasks
	 *     FOR EACH ROW
	 *     WHEN (NEW.status = 'Aceptada')
	 * EXECUTE FUNCTION task_accepted_trigger();
	 *
	 * -- Asociar el trigger de rechazar a la acción de rechazar en la tabla tasks
	 * CREATE TRIGGER task_reject
	 *     AFTER INSERT
	 *     ON tasks
	 *     FOR EACH ROW
	 *     WHEN (NEW.status = 'Rechazada')
	 * EXECUTE FUNCTION task_rejected_trigger();
	 *
	 * -- Asociar el trigger de cancelar a la acción de cancelar en la tabla tasks
	 * CREATE TRIGGER task_cancel
	 *     AFTER UPDATE
	 *     ON tasks
	 *     FOR EACH ROW
	 *     WHEN (OLD.status <> NEW.status AND NEW.status = 'Cancelada')
	 * EXECUTE FUNCTION task_cancelled_trigger();
	 *
	 * -- Asociar el trigger de terminar a la acción de terminar en la tabla tasks
	 * CREATE TRIGGER task_complete
	 *     AFTER UPDATE
	 *     ON tasks
	 *     FOR EACH ROW
	 *     WHEN (OLD.status <> NEW.status AND NEW.status = 'Completada')
	 * EXECUTE FUNCTION task_completed_trigger();
	 *
	 *
	 * ----------------------------------------------------------------------------------------
	 */

}
