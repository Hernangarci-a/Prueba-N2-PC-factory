package com.example.pcfactory.dto;

import java.util.List;
import lombok.Data;

@Data
public class TipoVentaDTO {
    private Integer idTipoVenta;
    private String nombre;
    private List<Integer> foliosVentas;
}