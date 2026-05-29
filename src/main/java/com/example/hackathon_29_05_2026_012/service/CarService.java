package com.example.hackathon_29_05_2026_012.service;

import org.springframework.data.domain.Page;
import com.example.hackathon_29_05_2026_012.model.dto.request.CarDto;
import com.example.hackathon_29_05_2026_012.model.entity.Car;

public interface CarService {
    // lấy + phân trang
    Page<Car> getCars(Integer page, Integer pageSize);

    // lấy theo id
    Car getCarById(Long id);

    // thêm
    Boolean createCar(CarDto carDto);

    // sửa
    Boolean updateCar(Long id, CarDto carDto);

    // xóa
    Boolean deleteCar(Long id);

    // tìm kiếm theo tên và brand + phân trang + sắp sếp
    Page<Car> searchCarByBrandContains(String brand, Integer page, Integer pageSize,
            String sortType);
}
