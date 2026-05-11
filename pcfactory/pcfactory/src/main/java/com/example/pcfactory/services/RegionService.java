package com.example.pcfactory.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pcfactory.dto.RegionDTO;
import com.example.pcfactory.model.Region;
import com.example.pcfactory.repository.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<RegionDTO> obtenerTodos() {
        return regionRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public RegionDTO buscarPorId(Integer id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no se encontro region con ID: " + id));
        return convertirADTO(region);
    }

    public Region guardarRegion(Region region) {
        if (region.getNombre_region() == null || region.getNombre_region().trim().isEmpty()) {
            throw new RuntimeException("el nombre no debe estar vacio");
        }
        return regionRepository.save(region);
    }

    public String eliminarRegion(Integer id) {
        try {
            Region region = regionRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("no se puede eliminar region con ID " + id + " no existe."));
            regionRepository.delete(region);
            return "la region " + region.getNombre_region() + " se elimino";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    private RegionDTO convertirADTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setIdRegion(region.getId_region());
        dto.setNombreRegion(region.getNombre_region());
        dto.setNombresComunas(new ArrayList<>());
        return dto;
    }
}