package com.example.demo.repositories;

import com.example.demo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.TaskStatus;

import java.util.List;

@RepositoryRestResource
public interface TaskStatusRepo extends JpaRepository<TaskStatus, Long> {

	@Query("SELECT ts FROM TaskStatus ts WHERE ts.name = :name")
	TaskStatus findByName(@Param("name") String name);


	@Query("SELECT t FROM Task t " +
			"WHERE t.id_task = :taskStatusId " +
			"AND t.id_task IN (" +
			"   SELECT tr.id_task FROM TaskRequirement tr " +
			"   WHERE tr.id_requirement IN (" +
			"       SELECT vr.id_requirement FROM VoluntaryRequirement vr " +
			"       WHERE vr.rut_voluntary = :voluntaryRut" +
			"   )" +
			")")
	List<Task> findAvailableTasksForVoluntary(@Param("voluntaryRut") String voluntaryRut,
											  @Param("taskStatusId") Long taskStatusId);
}
