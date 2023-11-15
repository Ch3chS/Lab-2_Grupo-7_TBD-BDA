package com.example.demo.controllers;

import com.example.demo.models.DateRange;
import com.example.demo.models.Emergency;
import com.example.demo.models.EmergencyDto;
import com.example.demo.services.EmergencyService;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/emergencies")
public class EmergencyController {

    @Autowired
    private EmergencyService service;

    @PostMapping
    public EmergencyDto createEmergency(@RequestBody EmergencyDto dto) {
        Emergency emergency = new Emergency();
        emergency.setId_emergency(dto.getId_emergency());
        emergency.setDescription(dto.getDescription());
        emergency.setDate(dto.getDate());
        emergency.setActive(dto.getActive());
        emergency.setId_institution(dto.getId_institution());

        WKTReader reader = new WKTReader();
        try {
            Point location = (Point) reader.read(dto.getLocation());
            emergency.setLocation(location);
        } catch (ParseException e) {
            // Manejar la excepción
        }

        Emergency savedEmergency = service.create(emergency);
        return convertToDto(savedEmergency);
    }

    @GetMapping
    public List<EmergencyDto> getAllEmergencies() {
        List<Emergency> emergencies = service.getAll();
        return emergencies.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmergencyDto getEmergencyById(@PathVariable Long id) {
        Emergency emergency = service.getById(id);
        return convertToDto(emergency);
    }

    @PutMapping("/{id}")
    public EmergencyDto updateEmergency(@PathVariable Long id, @RequestBody EmergencyDto dto) {
        Emergency emergency = new Emergency();
        emergency.setId_emergency(dto.getId_emergency());
        emergency.setDescription(dto.getDescription());
        emergency.setDate(dto.getDate());
        emergency.setActive(dto.getActive());
        emergency.setId_institution(dto.getId_institution());

        WKTReader reader = new WKTReader();
        try {
            Point location = (Point) reader.read(dto.getLocation());
            emergency.setLocation(location);
        } catch (ParseException e) {
            // Manejar la excepción
        }

        Emergency updatedEmergency = service.update(id, emergency);
        return convertToDto(updatedEmergency);
    }

    @DeleteMapping("/{id}")
    public void deleteEmergency(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/byDate")
    public List<EmergencyDto> getEmergenciesByDate(@RequestBody DateRange dateRange) throws Exception {
        List<Emergency> emergencies = service.getByDate(dateRange.getStartDate(), dateRange.getEndDate());
        return emergencies.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/byVoluntaryLocation/{rut}")
    public List<EmergencyDto> getEmergenciesByVoluntaryLocation(@PathVariable String rut) {
        List<Emergency> emergencies = service.getByVoluntaryLocation(rut);
        return emergencies.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private EmergencyDto convertToDto(Emergency emergency) {
        EmergencyDto dto = new EmergencyDto();
        dto.setId_emergency(emergency.getId_emergency());
        dto.setDescription(emergency.getDescription());
        dto.setDate(emergency.getDate());
        dto.setActive(emergency.getActive());
        dto.setId_institution(emergency.getId_institution());
        dto.setLocation(emergency.getLocation().toText());
        return dto;
    }
}
