package com.example.hackathon_29_05_2026_012.model.entity;

import com.example.hackathon_29_05_2026_012.model.enumType.StatusCar;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String brand;
    private Double price;
    private StatusCar status;
    private Boolean is_delete;
}
