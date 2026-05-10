package com.example.pcfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcfactory.model.TipoPago;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer> {

}
