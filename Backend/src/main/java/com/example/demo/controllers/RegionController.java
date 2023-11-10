package com.example.demo.controllers;

import com.example.demo.models.Region;
import com.example.demo.models.RegionDto;
import com.example.demo.services.RegionService;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService service;

    @PostMapping
    public RegionDto createRegion(@RequestBody RegionDto dto) {
        Region region = new Region();
        region.setIdRegion(dto.getIdRegion());
        region.setName(dto.getName());

        WKTReader reader = new WKTReader();
        try {
            MultiPolygon geom = (MultiPolygon) reader.read(dto.getGeom());
            region.setGeom(geom);
        } catch (ParseException e) {
            // Manejar la excepción
        }

        Region savedRegion = service.create(region);
        return convertToDto(savedRegion);
    }

    @GetMapping
    public List<RegionDto> getAllRegions() {
        List<Region> regions = service.getAll();
        return regions.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RegionDto getRegionById(@PathVariable Long id) {
        Region region = service.getById(id);
        System.out.println(region.getName());
        return convertToDto(region);
    }

    @PutMapping
    public RegionDto updateRegion(@RequestBody RegionDto dto) {
        Region region = new Region();
        region.setIdRegion(dto.getIdRegion());
        region.setName(dto.getName());

        WKTReader reader = new WKTReader();
        try {
            MultiPolygon geom = (MultiPolygon) reader.read(dto.getGeom());
            region.setGeom(geom);
        } catch (ParseException e) {
            // Manejar la excepción
        }

        Region updatedRegion = service.update(region);
        return convertToDto(updatedRegion);
    }

    @DeleteMapping("/{id}")
    public void deleteRegion(@PathVariable Long id) {
        service.delete(id);
    }

    private RegionDto convertToDto(Region region) {
        RegionDto dto = new RegionDto();
        dto.setIdRegion(region.getIdRegion());
        dto.setName(region.getName());
        dto.setGeom(region.getGeom().toText());
        return dto;
    }
}
