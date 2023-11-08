package com.example.demo.services;

import com.example.demo.models.QueryLog;
import com.example.demo.repositories.QueryLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryLogService {

	@Autowired
	private QueryLogRepo repo;

	/**
	 * Obtener las querys de un usuario
	 * @Return lista de querys
	 */
	public List<QueryLog> getByUsername(String username) {
		return repo.findByIdUsername(username);
	}

	/**
	 * Obtener la cantidad de querys que tienen los usuario de forma descendiente
	 * @Return lista de querys
	 */

	public List<Object[]> getQueryCountsByUsername(String query_text) {
		return repo.findQueryCountsByUsername(query_text);
	}
}
