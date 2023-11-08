package com.example.demo.repositories;

import com.example.demo.models.QueryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface QueryLogRepo extends JpaRepository<QueryLog, Long>{

	@Query("SELECT e FROM QueryLog e WHERE e .username = :username")
	List<QueryLog> findByIdUsername(@Param("username") String username);

	@Query("SELECT e.username, COUNT(e) AS queryCount " +
			"FROM QueryLog e " +
			"WHERE e.query_text LIKE %:query_text% " +
			"GROUP BY e.username " +
			"ORDER BY queryCount DESC")
	List<Object[]> findQueryCountsByUsername(@Param("query_text") String query_text);

}
