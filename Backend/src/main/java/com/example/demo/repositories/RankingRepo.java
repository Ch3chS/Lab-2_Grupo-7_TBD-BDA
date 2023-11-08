package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Ranking;

@RepositoryRestResource
public interface RankingRepo extends JpaRepository<Ranking, Long> {
    
    @Query("SELECT r FROM Ranking r WHERE r.id_task = :id_task ORDER BY r.score ASC")
    List<Ranking> findById_Task(@Param("id_task") Long id_task);

    @Query("SELECT r FROM Ranking r WHERE r.rut_voluntary = :rut_voluntary")
    List<Ranking> findByRut_Voluntary(@Param("rut_voluntary") String rut_voluntary);

}

