package com.example.pcfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcfactory.model.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {

}
