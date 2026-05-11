package com.example.pcfactory.dto;

import java.util.List;
import lombok.Data;

@Data
public class MarcaDTO {
    private Integer idMarca;
    private String nombreMarca;
    private List<String> nombresProductos;
}