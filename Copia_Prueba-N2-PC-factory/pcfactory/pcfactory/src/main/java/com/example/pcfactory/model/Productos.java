package com.example.pcfactory.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio") // Validación de Java no puede ser nulo ni estar vacío
    @Size(min = 3, max = 25, message = "El nombre debe tener entre 3 y 25 caracteres") // Límite de caracteres
    @Column(nullable = false, length = 25) // Esto es lo mismo que NOT NULL y VARCHAR(25) en la base de datos
    private String nombre_producto;

    @NotNull(message = "El precio no puede estar vacio")
    @Max(value = 100000)
    @Positive(message = "El precio debe ser mayor a cero")
    @Column(nullable = false)
    private double precioUnitario;

    @Column(length = 70)
    private String procesador;

    @Column(length = 20)
    private String memoria_ram;

    @Column(length = 20)
    private String almacenamiento;

    @ManyToOne
    @JoinColumn(name = "tipo_producto_id")
    private TipoProducto tipoProducto;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToMany
    @JoinTable(name = "productos_ventas", // El nombre que definido en el modelo
            joinColumns = @JoinColumn(name = "producto_id"), // Llave de esta tabla
            inverseJoinColumns = @JoinColumn(name = "ventas_id")) // Llave de la otra tabla
    private List<Ventas> ventas; // Ahora es una lista, porque puede tener muchas ventas

}
