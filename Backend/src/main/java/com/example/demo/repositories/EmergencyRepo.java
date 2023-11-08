package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Emergency;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource
public interface EmergencyRepo extends JpaRepository<Emergency, Long> {
    
    @Query("SELECT e FROM Emergency e WHERE e.id_institution = :id_institution")
    List<Emergency> findByIdInstitution(@Param("id_institution") Long id_institution);

    @Query("SELECT e FROM Emergency e WHERE e.date BETWEEN :startDate AND :endDate")
    List<Emergency> findByDateBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    
}

