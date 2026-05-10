package com.example.pcfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcfactory.model.TipoColaborador;

@Repository
public interface TipoColaboradorRepository extends JpaRepository<TipoColaborador, Integer> {

}
