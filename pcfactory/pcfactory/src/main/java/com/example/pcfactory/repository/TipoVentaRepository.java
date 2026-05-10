package com.example.pcfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcfactory.model.TipoVenta;

@Repository
public interface TipoVentaRepository extends JpaRepository<TipoVenta, Integer

> {

}
