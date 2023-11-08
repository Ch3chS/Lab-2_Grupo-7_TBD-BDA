package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.EmergencyRequirement;

@RepositoryRestResource
public interface EmergencyRequirementRepo extends JpaRepository<EmergencyRequirement, Long> {
    
    @Query("SELECT e FROM EmergencyRequirement e WHERE e.id_emergency = :id_emergency")
    List<EmergencyRequirement> findByIdEmergency(@Param("id_emergency") Long id_emergency);

    @Query("SELECT e FROM EmergencyRequirement e WHERE e.id_requirement = :id_requirement")
    List<EmergencyRequirement> findByIdRequirement(@Param("id_requirement") Long id_requirement);
}
