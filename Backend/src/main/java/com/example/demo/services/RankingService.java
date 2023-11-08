package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Ranking;
import com.example.demo.models.Voluntary;
import com.example.demo.repositories.RankingRepo;
import com.example.demo.repositories.VoluntaryRepo;

/**
 * Lógica detras del modelo Ranking, para los servicios de la aplicación con respecto al mismo.
 * Corresponde al CRUD del modelo, por lo que tendrá creación, lectura, actualización y eliminación.
 * @author Grupo 7 - TBD/BDA sección A-1 semestre 2-2023
 * @version 1.0
 */
@Service
public class RankingService {
  
    @Autowired
    private RankingRepo repo;

    @Autowired
    private VoluntaryRepo voluntaryRepo;

    /**
     * Creación de un ranking
     * Corresponde al Create del CRUD
     * @param ranking entidad a almacenar en la base de datos
     * @return entidad almacenada
     */
    public Ranking create(Ranking ranking) {
        return repo.save(ranking);
    }

    /**
     * Obtener todas los rankings
     * @return todas las entidades de la tabla
     */
    public List<Ranking> getAll() {
        return repo.findAll();
    }

    /**
     * Obtener Ranking por id
     * Corresponde al Read del CRUD
     * @param id id de la entidad
     * @return entidad con la id respectiva (o null en caso de no encontrarse)
     */
    public Ranking getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /**
     * Actualizar Ranking por id
     * Corresponde al Update del CRUD
     * @param id id de la entidad
     * @return entidad actualizada (o null en caso de no encontrarse)
     */
    public Ranking update(Long id, Ranking rankingDetails) {
        Ranking ranking = repo.findById(id).orElse(null);
        if (ranking != null) {
            ranking.setScore(rankingDetails.getScore());
            return repo.save(ranking);
        }
        return null;
    }

    /**
     * Eliminar Ranking por id
     * Corresponde al Delete del CRUD
     * @param id id de la entidad
     */
    public void delete(Long id) {
        Ranking ranking = repo.findById(id).orElse(null);
        if (ranking != null) {
            repo.delete(ranking);
        }
    }




    // ---------------------------------- Métodos para eliminación de cascada ----------------------------------

    /**
     * Eliminar por id_task
     * @param id_task id de la tarea
     */
    public void deleteByIdTask(Long id_task) {
        List<Ranking> rankings = repo.findById_Task(id_task);
        if (rankings != null) {
            repo.deleteAll(rankings);
        }
    }

    /**
     * Eliminar por rut_voluntary
     * @param rut_voluntary rut del voluntario
     */
    public void deleteByRutVoluntary(String rut_voluntary) {
        List<Ranking> ranking = repo.findByRut_Voluntary(rut_voluntary);
        if (ranking != null) {
            repo.deleteAll(ranking);
        }
    }

    // -------------------------------- Extra -------------------------------

    public Voluntary getMinRankingVoluntary(Long id) {
        List<Ranking> rankings = repo.findById_Task(id);
    
        if (!rankings.isEmpty()) {
            // Obtiene el primer ranking de la lista, que debería ser el de menor puntaje
            Ranking minRanking = rankings.get(0);
            
            // Se obtiene el rut del voluntario con menor puntaje
            String rut = minRanking.getRut_voluntary();
    
            System.out.println("Rut del voluntario con menor puntaje: " + rut);
    
            // Se obtiene el voluntario con ese rut
            Voluntary volunteer = voluntaryRepo.findByRut(rut);
    
            if (volunteer != null) {
                System.out.println("Voluntario encontrado: " + volunteer);
                return volunteer;
            } else {
                System.out.println("No se encontró un voluntario con el rut " + rut);
            }
        } else {
            System.out.println("No se encontraron rankings para la tarea con ID " + id);
        }
        return null;
    }
    
    

}
