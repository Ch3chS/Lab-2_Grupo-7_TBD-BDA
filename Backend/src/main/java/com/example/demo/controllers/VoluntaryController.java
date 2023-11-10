package com.example.demo.controllers;

import com.example.demo.models.Voluntary;
import com.example.demo.models.VoluntaryDto;
import com.example.demo.services.VoluntaryService;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/voluntaries")
public class VoluntaryController {

    @Autowired
    private VoluntaryService service;

    @PostMapping
    public VoluntaryDto createVoluntary(@RequestBody VoluntaryDto dto) {
        Voluntary voluntary = new Voluntary();
        voluntary.setRut(dto.getRut());
        voluntary.setName(dto.getName());
        voluntary.setLastnames(dto.getLastnames());
        voluntary.setEmail(dto.getEmail());
        voluntary.setPassword(dto.getPassword());
        voluntary.setPhone(dto.getPhone());
        voluntary.setAvaible(dto.getAvaible());

        WKTReader reader = new WKTReader();
        try {
            Point location = (Point) reader.read(dto.getLocation());
            voluntary.setLocation(location);
        } catch (ParseException e) {
            // Manejar la excepción
        }

        Voluntary savedVoluntary = service.create(voluntary);
        return convertToDto(savedVoluntary);
    }

    @GetMapping
    public List<VoluntaryDto> getAllVoluntaries() {
        List<Voluntary> voluntaries = service.getAll();
        return voluntaries.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{rut}")
    public VoluntaryDto getVoluntaryById(@PathVariable String rut) {
        Voluntary voluntary = service.getById(rut);
        return convertToDto(voluntary);
    }

    @PutMapping("/{rut}")
    public VoluntaryDto updateVoluntary(@PathVariable String rut, @RequestBody VoluntaryDto dto) {
        Voluntary voluntary = new Voluntary();
        voluntary.setRut(dto.getRut());
        voluntary.setName(dto.getName());
        voluntary.setLastnames(dto.getLastnames());
        voluntary.setEmail(dto.getEmail());
        voluntary.setPassword(dto.getPassword());
        voluntary.setPhone(dto.getPhone());
        voluntary.setAvaible(dto.getAvaible());

        WKTReader reader = new WKTReader();
        try {
            Point location = (Point) reader.read(dto.getLocation());
            voluntary.setLocation(location);
        } catch (ParseException e) {
            // Manejar la excepción
        }

        Voluntary updatedVoluntary = service.update(rut, voluntary);
        return convertToDto(updatedVoluntary);
    }

    @DeleteMapping("/{rut}")
    public void deleteVoluntary(@PathVariable String rut) {
        service.delete(rut);
    }

    // Método para registrar un nuevo voluntario
    @PostMapping("/register")
    public ResponseEntity<VoluntaryDto> register(@RequestBody VoluntaryDto dto) {
        Voluntary voluntary = new Voluntary();
        voluntary.setRut(dto.getRut());
        voluntary.setName(dto.getName());
        voluntary.setLastnames(dto.getLastnames());
        voluntary.setEmail(dto.getEmail());
        voluntary.setPassword(dto.getPassword());
        voluntary.setPhone(dto.getPhone());
        voluntary.setAvaible(dto.getAvaible());

        WKTReader reader = new WKTReader();
        try {
            Point location = (Point) reader.read(dto.getLocation());
            voluntary.setLocation(location);
        } catch (ParseException e) {
            // Manejar la excepción
        }

        Voluntary registeredVoluntary = service.register(voluntary);
        return new ResponseEntity<>(convertToDto(registeredVoluntary), HttpStatus.CREATED);
    }

    // Método para iniciar sesión con un voluntario existente
    @PostMapping("/login")
    public ResponseEntity<VoluntaryDto> login(@RequestBody VoluntaryDto dto) {
        Voluntary loggedInVoluntary = service.login(dto.getRut(), dto.getPassword());
        if (loggedInVoluntary == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(convertToDto(loggedInVoluntary), HttpStatus.OK);
        }
    }

    private VoluntaryDto convertToDto(Voluntary voluntary) {
        VoluntaryDto dto = new VoluntaryDto();
        dto.setRut(voluntary.getRut());
        dto.setName(voluntary.getName());
        dto.setLastnames(voluntary.getLastnames());
        dto.setEmail(voluntary.getEmail());
        dto.setPassword(voluntary.getPassword());
        dto.setPhone(voluntary.getPhone());
        dto.setAvaible(voluntary.getAvaible());
        dto.setLocation(voluntary.getLocation().toText());
        return dto;
    }
}
