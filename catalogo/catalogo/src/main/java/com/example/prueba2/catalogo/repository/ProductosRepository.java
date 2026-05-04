package com.example.prueba2.catalogo.repository;

import com.example.prueba2.catalogo.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository le dice a Spring que esta interfaz manejará el acceso a datos
@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    // Aquí podemos agregar métodos de búsqueda personalizados
}
