package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.VoluntaryRequirement;

import java.util.List;

@RepositoryRestResource
public interface VoluntaryRequirementRepo extends JpaRepository<VoluntaryRequirement, Long> {
    
    @Query("SELECT r FROM VoluntaryRequirement r WHERE r.id_requirement = :id_requirement")
    List<VoluntaryRequirement> findByIdRequirement(@Param("id_requirement") Long id_requirement);

    @Query("SELECT r FROM VoluntaryRequirement r WHERE r.rut_voluntary = :rut_voluntary")
    List<VoluntaryRequirement> findByRutVoluntary(@Param("rut_voluntary") String rut_voluntary);
}

