package com.example.pcfactory.dto;

import java.util.List;
import lombok.Data;

@Data
public class TipoDespachoDTO {
    private Integer idTipoDespacho;
    private String nombreTipoDespacho;
    private List<Integer> foliosVentas;
}