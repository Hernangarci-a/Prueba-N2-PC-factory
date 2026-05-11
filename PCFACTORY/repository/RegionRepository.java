package com.example.pcfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pcfactory.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

}
