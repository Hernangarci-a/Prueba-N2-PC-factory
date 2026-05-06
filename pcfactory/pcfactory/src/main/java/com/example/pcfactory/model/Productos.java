package com.example.pcfactory.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data // Genera automáticamente Getters, Setters y toString
@AllArgsConstructor // Crea un constructor con todos los atributos
@NoArgsConstructor // Crea un constructor vacío

// JPA y base de datos
@Entity // Marca esta clase como una tabla de la base de datos
@Table(name = "productos") // Indica el nombre exacto de la tabla en MySQL
public class Productos {

    @Id // Define la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que es AUTO_INCREMENT en MySQL
    private Integer id;

    // Validaciones y columnas
    @NotBlank(message = "El nombre es obligatorio") // Validación de Java no puede ser nulo ni estar vacío
    @Size(min = 3, max = 25, message = "El nombre debe tener entre 3 y 25 caracteres") // Límite de caracteres
    @Column(nullable = false, length = 25) // Esto es lo mismo que NOT NULL y VARCHAR(25) en la base de datos
    private String nombre_producto;

    @NotNull(message = "El precio no puede estar vacio")
    @Column(name = "precio", nullable = false)
    private double precio;

    @Column(nullable = true, length = 70)
    private String procesador;

    @Column(nullable = true, length = 20)
    private String memoria_ram;

    @Column(nullable = true, length = 20)
    private String almacenamiento;

    // Relacion muchos productos tiene muchas categorias
    @ManyToMany
    @JoinTable(name = "categoria_producto", // El nombre que definido en el modelo
            joinColumns = @JoinColumn(name = "producto_id"), // Llave de esta tabla
            inverseJoinColumns = @JoinColumn(name = "categoria_id")) // Llave de la otra tabla
    private List<Categoria> categorias; // Ahora es una lista, porque puede tener muchas categorias

    // Relacion muchos productos tienen una marca
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

}
