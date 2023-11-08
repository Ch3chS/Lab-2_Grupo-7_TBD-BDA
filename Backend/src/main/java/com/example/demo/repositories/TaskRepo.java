package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Task;

@RepositoryRestResource
public interface TaskRepo extends JpaRepository<Task, Long> {
    
    @Query("SELECT t FROM Task t WHERE t.id_taskStatus = :id_taskStatus")
    List<Task> findByIdTaskStatus(@Param("id_taskStatus") Long id_taskStatus);

    @Query("SELECT t FROM Task t WHERE t.id_emergency = :id_emergency")
    List<Task> findByIdEmergency(@Param("id_emergency") Long id_emergency);

}
