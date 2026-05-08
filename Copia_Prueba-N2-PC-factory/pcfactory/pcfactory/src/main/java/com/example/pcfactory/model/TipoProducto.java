package com.example.pcfactory.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipos_productos") // clase padre
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoProducto;

    @NotBlank(message = "El nombre del tipo es obligatorio")
    @Column(nullable = false, length = 50)
    private String nombre;

    // esto me recuerda a desarrollo orientado a objetos durante mi analisis
    // la clase categoria es el abuelo
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    // mientras la clase productos es el hijo
    @OneToMany(mappedBy = "tipoProducto")
    private List<Productos> productos;
}
