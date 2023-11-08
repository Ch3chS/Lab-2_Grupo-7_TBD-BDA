package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Institution;
import com.example.demo.repositories.InstitutionRepo;

/**
 * Lógica detras del modelo Institution, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class InstitutionService {
    
    @Autowired
    private InstitutionRepo repo;

    @Autowired
    private EmergencyService emergencyService;

    /**
     * Creación de una institución
     * Corresponde al Create del CRUD
     * @param institution entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Institution create(Institution institution) {
        return repo.save(institution);
    }

    /**
     * Obtener todas las instituciones
     * @return todas las entidades de la tabla
     */
    public List<Institution> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener institución por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Institution getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar institución por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Institution update(Long id, Institution institutionDetails) {
        Institution institution = repo.findById(id).orElse(null);
        if(institution != null) {
            institution.setName(institutionDetails.getName());
        }
        return null;
    }

    /**
     * Eliminar institución por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Institution institution = repo.findById(id).orElse(null);
        if (institution != null) {

            // Eliminar todas las entidades relacionadas en la clase Emergency
            emergencyService.deleteByIdInstitution(id);

            // Finalmente, eliminar la institución
            repo.delete(institution);
        }
    }

}
