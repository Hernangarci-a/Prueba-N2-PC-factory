package com.example.pcfactory.dto;

import java.util.List;
import lombok.Data;

@Data
public class CategoriaDTO {

    private Integer idCategoria;
    private String nombrCategoria;
    private List<String> nombresProductos;
}
