package com.example.pcfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcfactory.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
