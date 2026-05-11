package com.example.pcfactory.dto;

import java.util.List;
import lombok.Data;

@Data
public class TipoColaboradorDTO {
    private Integer idTipoColaborador;
    private String nombre;
    private List<String> nombresColaboradores;
}