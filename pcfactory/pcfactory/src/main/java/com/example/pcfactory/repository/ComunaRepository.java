package com.example.pcfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcfactory.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {

}
