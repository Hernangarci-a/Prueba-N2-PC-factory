package com.example.pcfactory.repository;
import  java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pcfactory.model.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
    List<Ventas> findByClienteRut(String rut);
}
