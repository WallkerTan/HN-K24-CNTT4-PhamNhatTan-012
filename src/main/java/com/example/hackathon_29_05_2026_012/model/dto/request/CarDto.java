package com.example.hackathon_29_05_2026_012.model.dto.request;

import com.example.hackathon_29_05_2026_012.model.enumType.StatusCar;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarDto {
    @NotBlank(message = "model khong duoc de trong")
    private String model;
    @NotBlank(message = "brand khong duoc de trong")
    private String brand;
    @Min(1)
    private Double price;
    @NotNull
    private StatusCar status;
    @NotNull
    private Boolean is_delete;
}
