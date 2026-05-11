package com.example.pcfactory.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pcfactory.dto.TipoDespachoDTO;
import com.example.pcfactory.model.TipoDespacho;
import com.example.pcfactory.repository.TipoDespachoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoDespachoService {
    @Autowired
    private TipoDespachoRepository tipoDespachoRepository;

    public List<TipoDespachoDTO> obtenerTodos(){
        return tipoDespachoRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

//No entiendo que hacer con este service



    public TipoDespachoDTO buscarPorId(Integer id) {
        TipoDespacho tipo = tipoDespachoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no se ha encontrado con ID: " + id));
        return convertirADTO(tipo);
    }

    private TipoDespachoDTO convertirADTO(TipoDespacho tipo){
        TipoDespachoDTO dto = new TipoDespachoDTO();
        dto.setIdTipoDespacho(tipo.getIdTipoDespacho());
        dto.setNombreTipoDespacho(tipo.getNombreTipoDespacho());
        return dto;
    }
}