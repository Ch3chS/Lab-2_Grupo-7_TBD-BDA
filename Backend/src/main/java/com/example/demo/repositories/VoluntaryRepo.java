package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Voluntary;

@RepositoryRestResource
public interface VoluntaryRepo extends JpaRepository<Voluntary, String> {
    Voluntary findByRut(String rut);
}
