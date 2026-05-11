package com.example.pcfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.pcfactory.model.TipoDespacho;

@Repository
public interface TipoDespachoRepository extends JpaRepository<TipoDespacho, Integer> {  
}
