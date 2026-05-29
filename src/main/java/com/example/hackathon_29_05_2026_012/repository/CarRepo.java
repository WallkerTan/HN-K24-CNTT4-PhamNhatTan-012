package com.example.hackathon_29_05_2026_012.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hackathon_29_05_2026_012.model.entity.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
    Page<Car> searchCarByNameAndBrandContains(String name, String brand, Pageable pageable);
}
