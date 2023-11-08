package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.TaskRequirement;

@RepositoryRestResource
public interface TaskRequirementRepo extends JpaRepository<TaskRequirement, Long> {
    
    @Query("SELECT t FROM TaskRequirement t WHERE t.id_task = :id_task")
    List<TaskRequirement> findByIdTask(@Param("id_task") Long id_task);

    @Query("SELECT t FROM TaskRequirement t WHERE t.id_requirement = :id_requirement")
    List<TaskRequirement> findByIdRequirement(@Param("id_requirement") Long id_requirement);
}
