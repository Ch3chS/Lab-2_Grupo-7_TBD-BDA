package com.example.demo.controllers;

import com.example.demo.models.QueryLog;
import com.example.demo.services.QueryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/querylogs")
public class QueryLogController {

	@Autowired
	private QueryLogService service;

	/**
	 * Obtener las querys de un usuario
	 * @Return lista de querys
	 */
	@GetMapping("/{username}")
	public List<QueryLog> getByUsername(@PathVariable String username) {
		return service.getByUsername(username);
	}

}
