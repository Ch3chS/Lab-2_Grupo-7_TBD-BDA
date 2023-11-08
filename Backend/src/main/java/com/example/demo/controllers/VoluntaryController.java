package com.example.demo.controllers;

import com.example.demo.models.Voluntary;
import com.example.demo.services.VoluntaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntaries")
public class VoluntaryController {

    @Autowired
    private VoluntaryService service;

    /* 
    @PostMapping
    public Voluntary createVoluntary(@RequestBody Voluntary voluntary) {
        return service.create(voluntary);
    }
    */
    @GetMapping
    public List<Voluntary> getAllVoluntaries() {
        return service.getAll();
    }

    @GetMapping("/{rut}")
    public Voluntary getVoluntaryById(@PathVariable String rut) {
        return service.getById(rut);
    }

    @PutMapping("/{rut}")
    public Voluntary updateVoluntary(@PathVariable String rut, @RequestBody Voluntary voluntary) {
        return service.update(rut, voluntary);
    }

    @DeleteMapping("/{rut}")
    public void deleteVoluntary(@PathVariable String rut) {
        service.delete(rut);
    }

    // Método para registrar un nuevo voluntario
    @PostMapping("/register")
    public ResponseEntity<Voluntary> register(@RequestBody Voluntary voluntary) {
        Voluntary registeredVoluntary = service.register(voluntary);
        return new ResponseEntity<>(registeredVoluntary, HttpStatus.CREATED);
    }

    // Método para iniciar sesión con un voluntario existente
    @PostMapping("/login")
    public ResponseEntity<Voluntary> login(@RequestBody Voluntary voluntary) {
        Voluntary loggedInVoluntary = service.login(voluntary.getRut(), voluntary.getPassword());
        if (loggedInVoluntary == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(loggedInVoluntary, HttpStatus.OK);
        }
    }
}
