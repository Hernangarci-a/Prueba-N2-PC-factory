package com.example.pcfactory.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pcfactory.dto.TipoColaboradorDTO;
import com.example.pcfactory.model.Colaborador;
import com.example.pcfactory.model.TipoColaborador;
import com.example.pcfactory.repository.TipoColaboradorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoColaboradorService {
    @Autowired
    private TipoColaboradorRepository tipoColaboradorRepository;

    public List<TipoColaboradorDTO> obtenerTodos(){
        return tipoColaboradorRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }


//No entiendo que hacer con este service


    public TipoColaboradorDTO buscarPorId(Integer id) {
        TipoColaborador tipo = tipoColaboradorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no se encontro con ID: " + id));
        return convertirADTO(tipo);
    }

    private TipoColaboradorDTO convertirADTO(TipoColaborador tipo){
        TipoColaboradorDTO dto = new TipoColaboradorDTO();
        dto.setIdTipoColaborador(tipo.getIdTipoColaborador());
        dto.setNombre(tipo.getNombre());

        if (tipo.getColaboradores()!= null){
            dto.setNombresColaboradores(tipo.getColaboradores().stream()
                    .map(Colaborador::getNombreColaborador)
                    .toList());
        } else{
            dto.setNombresColaboradores(new ArrayList<>());
        }
        return dto;
    }
}